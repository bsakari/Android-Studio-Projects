package com.kingwanyama.notification_dialog;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
            //NOTIFICATION LISTENER
    public void notify(View view) {
        String message = "Mbuyu Hiyo Story kuliendaje?";
        Intent open  = new Intent(this,MessageActivity.class);
        open.putExtra("message",message);

        PendingIntent pending = PendingIntent.getActivity(this,2000,open,0);



        Notification noti = new Notification.Builder(this)
                .setContentIntent(pending)
                .setContentTitle("New Message")
                //.setContentText(message)
                .setSmallIcon(R.drawable.notinoti)
                .setAutoCancel(true)
                .build();
        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        manager.notify(0,noti);
    }



    //DIALOG LISTENER
    public void dialog(View view) {
MyDialog d = new MyDialog();
        d.show(getSupportFragmentManager(),"Dialog");

    }
}
