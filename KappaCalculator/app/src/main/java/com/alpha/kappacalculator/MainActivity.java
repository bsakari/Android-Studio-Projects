package com.alpha.kappacalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText num1,num2;
    private Button btn_add,btn_subtract,btn_divide,btn_multiply;
    private TextView result;
    private String firstNumber,secondNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        num1 = (EditText) findViewById(R.id.fnum);
        num2 = (EditText) findViewById(R.id.snum);
        btn_add = (Button) findViewById(R.id.btn1);
        btn_subtract = (Button) findViewById(R.id.btn2);
        btn_divide = (Button) findViewById(R.id.btn3);
        btn_multiply = (Button) findViewById(R.id.btn4);
        result = (TextView) findViewById(R.id.tvanswer);
        btn_add.setOnClickListener(this);
        btn_subtract.setOnClickListener(this);
        btn_divide.setOnClickListener(this);
        btn_multiply.setOnClickListener(this);
    }
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
