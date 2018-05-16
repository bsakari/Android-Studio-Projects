package com.alpha.arithmeticapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText num1,num2;
    TextView jibu;
    int answer;
    Button button;
    String number_one,number_two;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        num1 = (EditText) findViewById(R.id.fnum);
        num2 = (EditText) findViewById(R.id.snum);
        jibu = (TextView) findViewById(R.id.tvanswer);
        button = (Button) findViewById(R.id.btn_calculate);
    }

    public void Culculate(View view) {
        try{
            number_one = num1.getText().toString().trim();
            number_two = num2.getText().toString().trim();
            if (number_one.isEmpty() || number_two.isEmpty()){
                Toast.makeText(this, "Fill In All Inputs", Toast.LENGTH_SHORT).show();
            }else {
                answer = Integer.parseInt(number_one)*Integer.parseInt(number_two);
                jibu.setText(String.valueOf(answer));
            }
        }catch (Exception e){
            Toast.makeText(this, "System Malfunction", Toast.LENGTH_SHORT).show();
            }
        }
    }

