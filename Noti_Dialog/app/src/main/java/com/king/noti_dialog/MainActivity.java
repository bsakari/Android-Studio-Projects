package com.king.noti_dialog;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    //DIALOG LISTENER
    public void dialog(View view) {


        MyDialog d = new MyDialog();
        d.show(getSupportFragmentManager(),"Dialog");

    }
}
