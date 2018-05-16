package com.kingwanyama.list;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    ListView list;
    String [] items = {"Kenya",
            "Uganda","Tanzania","Zaire",
            "Zambia","Gambia","Botswana",
            "Benin","Ghana","Morocco",
            "Egypt","Nigeria","Sudan",
            "Kenya","Kenya","Kenya",
            "Somalia","Mali","Guinea Bisau",
            "DRC Congo","Malawi","France"};


    ArrayAdapter<String> kingwanyama;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         list = (ListView) findViewById(R.id.list1);
        kingwanyama = new ArrayAdapter<String>(this,R.layout.urembo,items);
        list.setAdapter(kingwanyama);

    }
}
