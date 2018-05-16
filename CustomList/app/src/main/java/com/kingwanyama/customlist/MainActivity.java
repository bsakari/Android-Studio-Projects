package com.kingwanyama.customlist;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView list;
    CustomAdapter2 adapter;
    ArrayList<Item> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list = (ListView) findViewById(R.id.complexList);
        data = new ArrayList<Item>();
        Item p1 = new Item("King Wanyama","kingwanyama@gmail.com",300000,R.drawable.img_1);
        Item p2 = new Item("Benjamin Wanyama","benjaminwanyama@gmail.com",600000,R.drawable.img_2);
        Item p3 = new Item("Sakari B Wanyama","swanyama@gmail.com",900000,R.drawable.img_3);
        Item p4 = new Item("B Sakari Wanyama","bswanyama@gmail.com",1200000,R.drawable.img_4);
        Item p5 = new Item("S B Wanyama","sbwanyama@gmail.com",1600000,R.drawable.img_5);
        Item p6 = new Item("Benjamin Sakari","kingbenjamin@gmail.com",1900000,R.drawable.img_6);
        Item p7 = new Item("Sakari Wanyama","sakariwanyama@gmail.com",2200000,R.drawable.img_7);
        Item p8 = new Item("Wanyama King","wanyamaking@gmail.com",2500000,R.drawable.img_8);
        Item p9 = new Item("Wanyama Sakari","kingwanyamasakari@gmail.com",2800000,R.drawable.img_9);
        Item p10 = new Item("Wanyama Benjamin","wanyamaben@gmail.com",3100000,R.drawable.img_10);
        Item p11 = new Item("King Benjamin Wanyama","kingbenjaminwanyama@gmail.com",3400000,R.drawable.img_11);
        data.add(p1);
        data.add(p2);
        data.add(p3);
        data.add(p4);
        data.add(p5);
        data.add(p6);
        data.add(p7);
        data.add(p8);
        data.add(p9);
        data.add(p10);
        data.add(p11);

        adapter = new CustomAdapter2(this, data);
        list.setAdapter(adapter);
    }
}


