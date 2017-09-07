package pl.kacperhes.mathy;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import Circles.Circles;
import Utilities.InvalidInputException;

import static android.widget.Toast.LENGTH_LONG;
import static android.widget.Toast.LENGTH_SHORT;

public class CirclesActivity extends AppCompatActivity {
    private EditText[] mEditText;
    private StringBuilder mStringBuilder;
    private TextView circleSolution;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circles);

        //Refer to fields
        mEditText = new EditText[] {
                (EditText) findViewById(R.id.circlesAX),
                (EditText) findViewById(R.id.circlesAY),
                (EditText) findViewById(R.id.circlesBX),
                (EditText) findViewById(R.id.circlesBY),
                (EditText) findViewById(R.id.circlesRad1),
                (EditText) findViewById(R.id.circlesRad2)
        };

    }

    public void calculateCircles(View view) {
        double ax, ay, bx, by;
        double radius1, radius2;

        InputMethodManager inputManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);

        for (EditText x : mEditText) {
            if (x.getText().toString().equals("")){
                Toast.makeText(this, "Fill in all fiels" , LENGTH_SHORT).show();
                x.setBackgroundColor(0x99FF5722);
            }
        }

        try{
            ax = Double.parseDouble(mEditText[0].getText().toString());
            ay = Double.parseDouble(mEditText[1].getText().toString());
            bx = Double.parseDouble(mEditText[2].getText().toString());
            by = Double.parseDouble(mEditText[3].getText().toString());
            radius1 = Double.parseDouble(mEditText[4].getText().toString());
            radius2 = Double.parseDouble(mEditText[5].getText().toString());

            Circles circles = new Circles(ax, ay, bx, by, radius1, radius2);
            mStringBuilder = new StringBuilder("");
            circleSolution = (TextView) findViewById(R.id.circlesSolution);

            mStringBuilder.append(circles.commonPos());

            circleSolution.setText(mStringBuilder.toString());

            throw new InvalidInputException();
        }catch (Exception e) {
            Toast.makeText(this, e.getMessage(), LENGTH_LONG).show();
        }
    }
}
