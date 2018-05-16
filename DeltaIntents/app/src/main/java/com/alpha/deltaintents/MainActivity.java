package com.alpha.deltaintents;

import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Call(View view) {
        Intent piga_simu = new Intent(Intent.ACTION_DIAL);
        piga_simu.setData(Uri.parse("tel:"));
        startActivity(piga_simu);
    }

    public void Message(View view) {
        Intent tuma_sms = new Intent(Intent.ACTION_MAIN);
        tuma_sms.setType("vnd.android-dir/mms-sms");
        startActivity(tuma_sms);
    }

    public void Camera(View view) {
        Intent piga_picha = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(piga_picha,0);
    }

    public void Share(View view) {
        Intent sambaza = new Intent(Intent.ACTION_SEND);
        sambaza.setType("plain/text");
        sambaza.putExtra(Intent.EXTRA_EMAIL, new String[] {"_ _ _"});
        sambaza.putExtra(Intent.EXTRA_SUBJECT,"_ _ _");
        startActivity(Intent.createChooser(sambaza,"Sharing"));
    }
}