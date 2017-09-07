package pl.kacperhes.mathy;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import Linear.Linear;
import Utilities.InvalidInputException;

public class LinearActivity extends AppCompatActivity {
    private EditText[] mEditText;
    private StringBuilder mStringBuilder;
    private TextView resultsLinear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear);

        //Extract value from fields
        mEditText = new EditText[] {
                (EditText) findViewById(R.id.linearAX),
                (EditText) findViewById(R.id.linearAY),
                (EditText) findViewById(R.id.linearBX),
                (EditText) findViewById(R.id.linearBY)
        };
    }

    public void countLinear(View view) {
        double ax, ay, bx, by;

        InputMethodManager inputManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);

        if (!mEditText[0].getText().equals("") && !mEditText[1].getText().equals("") && !mEditText[2].getText().equals("") && !mEditText[3].getText().equals("")){
            try{
                ax = Double.parseDouble(mEditText[0].getText().toString());
                ay = Double.parseDouble(mEditText[1].getText().toString());
                bx = Double.parseDouble(mEditText[2].getText().toString());
                by = Double.parseDouble(mEditText[3].getText().toString());

                if (ax == bx) {
                    Toast.makeText(this, "This is not function", Toast.LENGTH_LONG).show();
                    throw new InvalidInputException();
                }

                mStringBuilder = new StringBuilder("");
                Linear linear = new Linear(ax, ay, bx ,by);

                //Add section
                mStringBuilder.append("|AB| = ")
                        .append(linear.section());

                //Direction factor
                mStringBuilder.append("\n\na = ")
                        .append(linear.getFactor());

                //Function form
                mStringBuilder.append("\n\n")
                        .append(linear.getForm());

                //Angle
                mStringBuilder.append("\n\nα = ")
                        .append(linear.getAngle());

                //Pasting the text
                resultsLinear = (TextView) findViewById(R.id.linearSolutions);
                resultsLinear.setText(mStringBuilder.toString());
            }catch (Exception e) {
                for (EditText x : mEditText) {
                    x.setBackgroundColor(0x99FF5722);
                }
                Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
    }
}
