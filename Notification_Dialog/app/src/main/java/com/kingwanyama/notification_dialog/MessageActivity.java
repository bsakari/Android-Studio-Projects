package com.kingwanyama.notification_dialog;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

public class MessageActivity extends AppCompatActivity {
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);
        text = (TextView) findViewById(R.id.tvmesssage);
        String message = getIntent().getStringExtra("message");
        text.setText(message);
    }
}
