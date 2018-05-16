
package com.kingwanyama.m_insure;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.Toast;

public class InfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        Bundle b = getIntent().getExtras();
        //get the position from the  bundle
        int position = b.getInt("key");

        WebView web = (WebView) findViewById(R.id.web);


        if (position == 0)
        {
            setTitle("NASA");
            web.loadUrl("file:///android_asset/img_1.png");
        }
        else if (position==1)
        {
            setTitle("TIBIM");
            web.loadUrl("file:///android_asset/img_2.png");
        }
        else if (position==2)
        {
            setTitle("THE");
            web.loadUrl("file:///android_asset/img_3.png");
        }
        else if (position==3)
        {
            setTitle("LORD");
            web.loadUrl("file:///android_asset/img_4.png");
        }
        else if (position==4)
        {
            setTitle("IS");
            web.loadUrl("file:///android_asset/img_5.png");
        }
        else if (position==5)
        {
            setTitle("MY");
            web.loadUrl("file:///android_asset/img_6.png");
        }
        else if (position==6)
        {
            setTitle("SHEPHERED");
            web.loadUrl("file:///android_asset/img_7.png");
        }
        else if (position==7)
        {
            setTitle("I SHALL");
            web.loadUrl("file:///android_asset/img_8.png");
        }
        else if (position==8)
        {
            setTitle("NOT");
            web.loadUrl("file:///android_asset/img_9.png");
        }
        else if (position==9)
        {
            setTitle("WANT");
            web.loadUrl("file:///android_asset/img_9.png");
        }
        else
        {
            Toast.makeText(this, "Updates Coming Up Soon", Toast.LENGTH_SHORT).show();
        }

    }
}
