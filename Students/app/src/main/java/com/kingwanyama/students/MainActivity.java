package com.kingwanyama.students;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.loopj.android.http.TextHttpResponseHandler;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity {

    EditText inputNames, inputEmail;
    Spinner spinnerCourse;
    ProgressDialog progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inputNames = (EditText) findViewById(R.id.input_names);
        inputEmail = (EditText) findViewById(R.id.input_email);
        spinnerCourse = (Spinner) findViewById(R.id.spinner_course);
        progress = new ProgressDialog(this);
        progress.setMessage("Sending Data To The Server");
    }

    public void save(View view) {

        String names = inputNames.getText().toString().trim();
        String email = inputEmail.getText().toString().trim();
        String course = spinnerCourse.getSelectedItem().toString();

        //Send Data To Server

        if (names.isEmpty()||email.isEmpty())
        {
            Toast.makeText(this, "Invalid Values", Toast.LENGTH_SHORT).show();
            return;
        }
        progress.show();

        String url = "http://jistymarketer.com/save.php";
        AsyncHttpClient client = new AsyncHttpClient();
        RequestParams params = new RequestParams();
        params.put("names",names);
        params.put("email",email);
        params.put("course",course);
        /*client.post(url, params, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {

            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }
        });*/


        client.post(url, params, new TextHttpResponseHandler() {
            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                Toast.makeText(MainActivity.this, "Failed To Send. Please Try Again", Toast.LENGTH_SHORT).show();
                progress.dismiss();


            }



            @Override
            public void onSuccess(int statusCode, Header[] headers, String responseString) {
                Toast.makeText(MainActivity.this, responseString, Toast.LENGTH_SHORT).show();
                progress.dismiss();
                inputNames.setText("");
                inputEmail.setText("");

            }
        });

    }
}
