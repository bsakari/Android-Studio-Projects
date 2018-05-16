package com.junior.juniormatatuapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Comments extends AppCompatActivity {
    Button btn_send;
    EditText editText;
    String phone;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comments);

        btn_send=findViewById(R .id.button);
        editText=findViewById(R.id.editText);


        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                phone=editText.getText().toString();


                Intent send= new Intent(Intent.ACTION_VIEW);
                send.putExtra("address",phone);
                send.putExtra("sms_body","This is the message body");
                send.setType("vnd.android-dir/mms-sms");

                startActivity(send);
                }



        });
    }
}
