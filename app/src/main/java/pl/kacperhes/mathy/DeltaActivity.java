package pl.kacperhes.mathy;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import Delta.Delta;
import Utilities.InvalidInputException;

public class DeltaActivity extends AppCompatActivity {
    private EditText[] mEditText;
    private TextView deltaSolutions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delta);

        //Set edit text array
        mEditText = new EditText[] {
                (EditText) findViewById(R.id.deltaA),
                (EditText) findViewById(R.id.deltaB),
                (EditText) findViewById(R.id.deltaC)
        };
    }

    public void countDelta(View view) {

        InputMethodManager inputManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);


        double a=0, b=0, c=0;
        boolean isValid;
        try{
            a = Double.parseDouble(mEditText[0].getText().toString());
            b = Double.parseDouble(mEditText[1].getText().toString());
            c = Double.parseDouble(mEditText[2].getText().toString());
            if (a == 0){
                Toast.makeText(this, "This is not quadratic function", Toast.LENGTH_SHORT).show();
                throw new InvalidInputException();
            }
            isValid = true;
        }catch (Exception e){
            isValid = false;
            for (EditText et: mEditText){
                et.setBackgroundColor(0x99FF5722);
            }
            Toast.makeText(this, "Fill in all fields", Toast.LENGTH_SHORT).show();
        }

        if (isValid){
            Delta delta = new Delta(a, b, c);

            //Delta value and rooted delta
            StringBuilder stringBuilder = new StringBuilder("");
            stringBuilder.append("Delta: ")
                    .append(delta.deltaValue());
            if (delta.deltaValue() >= 0){
                stringBuilder.append("\n\nRooted delta: ")
                        .append(delta.rootedDelta());
            }

            //Delta roots
            if (delta.deltaRoots().length == 0) {
                stringBuilder.append("\n\nNo roots!");
            }else if (delta.deltaRoots().length == 1) {
                stringBuilder.append("\n\nx₀ =")
                        .append(delta.deltaRoots()[0]);
            }else{
                stringBuilder.append("\n\nx₁ = ")
                        .append(delta.deltaRoots()[0])
                        .append("\n\nx₂ = ")
                        .append(delta.deltaRoots()[1]);
            }

            //Picks
            stringBuilder.append("\n\n" + delta.getPicks());

            //Canonical form
            stringBuilder.append("\n\nCanonical: ")
                    .append(delta.getCanonicalForm());

            //Product form
            stringBuilder.append("\n\nProduct: ")
                    .append(delta.getProductForm());

            //Pasting the text to TextView
            deltaSolutions = (TextView) findViewById(R.id.deltaSolutions);
            deltaSolutions.setText(stringBuilder.toString());
        }
    }
}
