package com.king.kappalistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    ListView list;
    String[] countries = {"Kenya","Uganda","Tanzania","Zaire",
            "Zambia","Gambia","Botswana","Ghana","Morocco","Benin"
    ,"Egypt","Nigeria","Sudan","Gambia","Botswana","Ghana","Morocco","Benin"
            ,"Egypt","Nigeria","Sudan"};
    ArrayAdapter<String> king_wanyama;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list = (ListView) findViewById(R.id.list_view);
        king_wanyama = new ArrayAdapter<String>(this,R.layout.item_layout,countries);
        list.setAdapter(king_wanyama);
    }
}
