package com.kingwanyama.calculation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText one,two;
    Button button;
    int ONE,TWO;
    double ANSWER;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        one = (EditText) findViewById(R.id.edt1);
        two = (EditText) findViewById(R.id.edt2);
        button = (Button) findViewById(R.id.btn1);
    }

    public void calculation(View view) {
        ONE = Integer.parseInt(one.getText().toString());
        TWO = Integer.parseInt(two.getText().toString());
        ANSWER = (double) ONE + TWO;
        Toast.makeText(this, Double.toString(ANSWER), Toast.LENGTH_LONG).show();

    }
}
