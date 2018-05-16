package com.kingwanyama.actionoutput;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button button;
    EditText one,two;
    TextView text;
    int ONE;
    int TWO;
    double ANSWER;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.btn1);
        one = (EditText) findViewById(R.id.edt1);
        two = (EditText) findViewById(R.id.edt2);
        text = (TextView) findViewById(R.id.tv1);

    }

    public void Combine(View view) {
//        ONE = one.getText().toString().trim();
//        TWO = two.getText().toString().trim();
//        ANSWER = ONE + TWO;

            ONE = Integer.parseInt(one.getText().toString());
            TWO = Integer.parseInt(two.getText().toString());
            ANSWER = ((double) ONE + TWO);
        Toast.makeText(this, Double.toString(ANSWER), Toast.LENGTH_SHORT).show();



    }
}
