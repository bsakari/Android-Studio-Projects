package com.alpha.calc;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button add,subtract,divide,multiply;
    private EditText firstNumber,secondNumber;
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        add = (Button) findViewById(R.id.btn1);
        subtract = (Button) findViewById(R.id.btn2);
        divide = (Button) findViewById(R.id.btn3);
        multiply = (Button) findViewById(R.id.btn4);
        firstNumber = (EditText) findViewById(R.id.fnum);
        secondNumber = (EditText) findViewById(R.id.snum);
        result = (TextView) findViewById(R.id.tvanswer);
        add.setOnClickListener(this);
        subtract.setOnClickListener(this);
        divide.setOnClickListener(this);
        multiply.setOnClickListener(this);
    }

    public void onClick(View view){
        String num1 = firstNumber.getText().toString();
        String num2 = secondNumber.getText().toString();
        switch (view.getId()){
            case R.id.btn1:
                double addition = (Double.parseDouble(num1)+Double.parseDouble(num2));
                result.setText(String.valueOf(addition));
                break;
            case R.id.btn2:
                double subtraction = (Double.parseDouble(num1)-Double.parseDouble(num2));
                result.setText(String.valueOf(subtraction));
                break;
            case R.id.btn3:
                double division = (Double.parseDouble(num1)/Double.parseDouble(num2));
                result.setText(String.valueOf(division));
                break;
            case R.id.btn4:
                double multiplication = Double.parseDouble(num1)*Double.parseDouble(num2);
                result.setText(String.valueOf(multiplication));
                break;
        }
    }


}
