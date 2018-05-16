package io.futurebound.listeners;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //declaing variables
    EditText inputUserName, inputPassword;
    Button btnSignIn;
    TextView inputNewUser, inputForgortPassword;
    //tag logt
    private static final String TAG = "FutureWizardry";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inputForgortPassword =(TextView) findViewById(R.id.inputForgortPassword);//alt Enter
        inputNewUser =(TextView) findViewById(R.id.inputNewUser);
        inputUserName =( EditText) findViewById(R.id.inputUserName);
        inputPassword =( EditText) findViewById(R.id.inputPassword);
        btnSignIn =(  Button) findViewById(R.id.btnSignIn);

        inputUserName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                inputUserName.setText(s.toString());

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        inputNewUser.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                return true;
            }
        });

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username= inputUserName.getText().toString().trim();
                String password= inputPassword.getText().toString().trim();
                if (username.equals("Mark")&& password.equals("1234"))
                {

                    //logcat==console logd or logi
                    Log.d(TAG, "Wizardry Absolute ");
                    Intent x = new Intent(MainActivity.this, LoggedInActivity.class);
                    startActivity(x);
                    finish();
                }
                else
                    {
                        Toast.makeText(MainActivity.this, "Wrong Username or password", Toast.LENGTH_SHORT).show();
                    }
            }
        });
    }
}
