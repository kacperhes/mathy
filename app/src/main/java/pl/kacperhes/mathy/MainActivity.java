package pl.kacperhes.mathy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void startQuadratic(View view) {
        Intent intent = new Intent(MainActivity.this, DeltaActivity.class);
        startActivity(intent);
    }

    public void startLinear(View view) {
        Intent intent = new Intent(this, LinearActivity.class);
        startActivity(intent);
    }

    public void startCircles(View view) {
        Intent intent = new Intent(this, CirclesActivity.class);
        startActivity(intent);
    }
}
