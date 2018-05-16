package com.alpha.deltacalc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText firstNumber,secondNumber;
    private TextView result;
    private Button add,subtract,divide,multiply;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        add = (Button) findViewById(R.id.btn_add);
        subtract = (Button) findViewById(R.id.btn_subtract);
        divide = (Button) findViewById(R.id.btn_divide);
        multiply = (Button) findViewById(R.id.btn_multiply);
        result = (TextView) findViewById(R.id.tvanswer);
        firstNumber = (EditText) findViewById(R.id.fnum);
        secondNumber = (EditText) findViewById(R.id.snum);
        add.setOnClickListener(this);
        subtract.setOnClickListener(this);
        divide.setOnClickListener(this);
        multiply.setOnClickListener(this);
    }
    public void onClick(View view){
        String num1 = firstNumber.getText().toString();
        String num2 = secondNumber.getText().toString();
        switch (view.getId()){
            case R.id.btn_add:
                double addition = Double.parseDouble(num1)+Double.parseDouble(num2);
                result.setText(String.valueOf(addition));
                break;
            case R.id.btn_subtract:
                double subtraction = Double.parseDouble(num1)-Double.parseDouble(num2);
                result.setText(String.valueOf(subtraction));
                break;
            case R.id.btn_divide:
                double division = Double.parseDouble(num1)/Double.parseDouble(num2);
                result.setText(String.valueOf(division));
                break;
            case R.id.btn_multiply:
                double multiplication = Double.parseDouble(num1)*Double.parseDouble(num2);
                result.setText(String.valueOf(multiplication));
                break;

        }
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
