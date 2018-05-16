package com.king.alphacomplexlist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView list;
    CustomAdapter adapter;
    ArrayList data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        data = new ArrayList<Item>();
        list = (ListView) findViewById(R.id.complex_list);
        Item user1 = new Item("King Wanyama","king@gmail.com",300000,R.drawable.img_1);
        Item user2 = new Item("King Wanyama","king@gmail.com",300000,R.drawable.img_2);
        Item user3 = new Item("King Wanyama","king@gmail.com",300000,R.drawable.img_3);
        Item user4 = new Item("King Wanyama","king@gmail.com",300000,R.drawable.img_4);
        Item user5 = new Item("King Wanyama","king@gmail.com",300000,R.drawable.img_5);
        Item user6 = new Item("King Wanyama","king@gmail.com",300000,R.drawable.img_6);
        Item user7 = new Item("King Wanyama","king@gmail.com",300000,R.drawable.img_7);
        Item user8 = new Item("King Wanyama","king@gmail.com",300000,R.drawable.img_8);
        Item user9 = new Item("King Wanyama","king@gmail.com",300000,R.drawable.img_9);
        data.add(user1);
        data.add(user2);
        data.add(user3);
        data.add(user4);
        data.add(user5);
        data.add(user6);
        data.add(user7);
        data.add(user8);
        data.add(user9);
        adapter = new CustomAdapter(this,data);
        list.setAdapter(adapter);
    }
}












