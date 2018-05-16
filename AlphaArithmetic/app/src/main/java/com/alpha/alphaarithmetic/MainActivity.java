package com.alpha.alphaarithmetic;

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
    String firstNumber,secondNumber;
    int answer;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        num1 = (EditText) findViewById(R.id.fnum);
        num2 = (EditText) findViewById(R.id.snum);
        jibu = (TextView) findViewById(R.id.tvanswer);
        button = (Button) findViewById(R.id.btn_calculate);
    }

    public void Calculate(View view) {
      try {
          firstNumber = num1.getText().toString().trim();
          secondNumber = num2.getText().toString().trim();
          if (firstNumber.isEmpty()||secondNumber.isEmpty()){
              Toast.makeText(this, "Fill In All Inputs", Toast.LENGTH_SHORT).show();
          }else {
              answer = Integer.parseInt(firstNumber)*Integer.parseInt(secondNumber);
              jibu.setText(String.valueOf(answer));
          }

      }catch (Exception e){
          Toast.makeText(this, "System Malfunction", Toast.LENGTH_SHORT).show();
      }
    }
}
