package com.junior.juniormatatuapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class Prices extends AppCompatActivity {
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prices);
        webView=findViewById(R.id.web_view);
        WebSettings settings =webView.getSettings();
        webView.loadUrl("file:///android_asset/junior.html");
    }
}
