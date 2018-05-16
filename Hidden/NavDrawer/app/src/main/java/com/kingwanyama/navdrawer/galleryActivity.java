package com.kingwanyama.navdrawer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class galleryActivity extends AppCompatActivity {

    WebView web;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        web = (WebView) findViewById(R.id.gallerywebview);
        web.loadUrl("file:///android_asset/gallery.html");

    }
}
