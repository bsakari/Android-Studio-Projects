package com.alpha.alphacalc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText num1,num2;
    private Button add,subtract,divide,multiply;
    private TextView result;
    private String firstNumber,secondNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        num1 = (EditText) findViewById(R.id.fnum);
        num2 = (EditText) findViewById(R.id.snum);
        add = (Button) findViewById(R.id.btn1);
        subtract = (Button) findViewById(R.id.btn2);
        divide = (Button) findViewById(R.id.btn3);
        multiply = (Button) findViewById(R.id.btn4);
        result = (TextView) findViewById(R.id.tvanswer);
        add.setOnClickListener(this);
        subtract.setOnClickListener(this);
        divide.setOnClickListener(this);
        multiply.setOnClickListener(this);
    }
    @Override
    public void onClick(View view){
        firstNumber = num1.getText().toString();
        secondNumber = num2.getText().toString();
        switch (view.getId()){
            case R.id.btn1:
                double addition = Double.parseDouble(firstNumber)+Double.parseDouble(secondNumber);
                result.setText(String.valueOf(addition));
                break;
            case R.id.btn2:
                double subtraction = Double.parseDouble(firstNumber)-Double.parseDouble(secondNumber);
                result.setText(String.valueOf(subtraction));
                break;
            case R.id.btn3:
                double division = Double.parseDouble(firstNumber)/Double.parseDouble(secondNumber);
                result.setText(String.valueOf(division));
                break;
            case R.id.btn4:
                double multiplication = Double.parseDouble(firstNumber)*Double.parseDouble(secondNumber);
                result.setText(String.valueOf(multiplication));
                break;
        }
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
