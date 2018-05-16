package com.king.deltacomplexlist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class WanyamaActivity extends AppCompatActivity {
    ImageView king;
    TextView text;
    String[] kingDe = {"King Wanyama","Ephy","Allels","Viv"};
    int[] images = {R.drawable.img_1,R.drawable.img_2
            ,R.drawable.img_3,R.drawable.img_4,R.drawable.img_5
            ,R.drawable.img_6,R.drawable.img_7
            ,R.drawable.img_8,
             R.drawable.img_9};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wanyama);
        text = (TextView) findViewById(R.id.mimi);
        king = (ImageView) findViewById(R.id.imageView);

        int position = getIntent().getIntExtra("Data", 0);

        king.setImageResource(images[position]);
        text.setText(kingDe[position]);

    }
}
