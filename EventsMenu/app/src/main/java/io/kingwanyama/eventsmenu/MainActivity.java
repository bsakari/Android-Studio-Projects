package io.kingwanyama.eventsmenu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText inputWeight;
    EditText inputHeight;
    TextView tvResults;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inputWeight = (EditText) findViewById(R.id.Weight);
        inputHeight = (EditText) findViewById(R.id.Height);
        tvResults = (TextView) findViewById(R.id.BMIResult);

        //tvResults.setText("Hapo Ndo Mwanzo Brathe");
    }

    public void Calculate(View view) {

    String weight = inputWeight.getText().toString().trim();
    String height = inputHeight.getText().toString().trim();

        try
        {
            double w = Double.parseDouble(weight);
            double h = Double.parseDouble(height);

            if (w>300||h>3||w<1 || h<0.2)
            {
                Toast.makeText(this, "Kindly Enter Correct Numbers", Toast.LENGTH_SHORT).show();
                return;
            }


            double BMI = w/(h*h);
            //tvResults.setText("BMI is "+BMI);


            if (BMI<15)
            {
                tvResults.setText("Very Severely Underweight");
            }

            else if (BMI >= 15 && BMI <16)
            {
                tvResults.setText("Severely Underweight");
            }

            else if (BMI >= 16 && BMI <18.5)
            {
                tvResults.setText("Underweight");
            }


            else if (BMI >= 18.5 && BMI <25)
            {
                tvResults.setText("Normal(Healthy Weight)");
            }



            else if (BMI >= 25 && BMI <30)
            {
                tvResults.setText("Overweight");
            }




            else if (BMI >= 30 && BMI <35)
            {
                tvResults.setText("Moderately Obase");
            }



            else if (BMI >= 35 && BMI <40)
            {
                tvResults.setText("Severely Obase");
            }



            else if (BMI >= 40)
            {
                tvResults.setText("Very Severely Obase");
            }

        }
catch (Exception x)
{
    Toast.makeText(this, "Fill In All Values", Toast.LENGTH_SHORT).show();
}


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.menuclear)
        {
            inputWeight.setText("");
            inputHeight.setText("");
            tvResults.setText("");
        }


        return true;
    }
}
