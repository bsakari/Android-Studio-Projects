package com.kingwanyama.camera;

import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static android.R.id.message;

public class MainActivity extends AppCompatActivity {
    Button btn,btn2,Calculate;
    TextView outtput;
    EditText a, b;
    String jibu, moja, mbili;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = (Button) findViewById(R.id.button);
        btn2 = (Button) findViewById(R.id.button2);
        Calculate = (Button) findViewById(R.id.btn3);
        outtput = (TextView) findViewById(R.id.text1);
        a= (EditText) findViewById(R.id.edit1);
        b= (EditText) findViewById(R.id.edit2);

    }

    public void Camera(View view) {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent,0);
    }

    public void sms(View view) {
        Intent message = new Intent(Intent.ACTION_MAIN);
        message.setType("vnd.android-dir/mms-sms");
        startActivity(message);
    }

    public void add(View view) {
        moja = a.getText().toString().trim();
        mbili = a.getText().toString().trim();
        jibu = moja + mbili;
        outtput.setText(jibu);

    }

    public void Call(View view) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("plain/text");
        intent.putExtra(Intent.EXTRA_EMAIL, new String[] { "---" });
        intent.putExtra(Intent.EXTRA_SUBJECT, "---");
        startActivity(Intent.createChooser(intent, "Contact Us!"));
    }
}
