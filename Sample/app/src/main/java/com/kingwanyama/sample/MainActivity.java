package com.kingwanyama.sample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText inputPrinciple;
    EditText inputRate;
    EditText inputTime;
    TextView tvInterest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputPrinciple = (EditText) findViewById(R.id.Principle);
        inputRate = (EditText) findViewById(R.id.Rate);
        inputTime = (EditText) findViewById(R.id.Time);
        tvInterest = (TextView) findViewById(R.id.outputInterest);


    }


    public void calculate(View view) {

        String principle = inputPrinciple.getText().toString().trim();
        String rate = inputRate.getText().toString().trim();
        String time = inputTime.getText().toString().trim();

        try
        {
            double p = Double.parseDouble(principle);
            double r = Double.parseDouble(rate);
            double t = Double.parseDouble(time);

            double PRINCIPLE = (p*r*t)/100;

            tvInterest.setText("Ksh "+PRINCIPLE);
        }
        catch (Exception x)
        {
            Toast.makeText(this, "Kindly Fill All The Blanks Before Calculating", Toast.LENGTH_SHORT).show();
        }

    }


}
