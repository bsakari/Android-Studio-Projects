package com.king.simple_list;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    ListView list;
    String[] countries = {"Kenya","Uganda","Tanzania","Australia",
            "Tanzania","Australia",
            "Tanzania","Australia","Tanzania","Australia",
            "Tanzania","Australia","Tanzania","Australia"};
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list = (ListView) findViewById(R.id.simple_list);
        adapter = new ArrayAdapter<String>(this,R.layout.item_layout,countries);
        list.setAdapter(adapter);

    }
}
