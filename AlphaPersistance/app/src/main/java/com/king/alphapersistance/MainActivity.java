package com.king.alphapersistance;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn;
    EditText text;
    CheckBox check;
    SharedPreferences prefs;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = (Button) findViewById(R.id.btn1);
        text = (EditText) findViewById(R.id.edt1);
        check = (CheckBox) findViewById(R.id.check1);
        prefs = getSharedPreferences("view",0);
        editor = prefs.edit();
        populate();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editor.putString("edit",text.getText().toString());
                editor.putBoolean("check",check.isChecked());
                editor.commit();
                Toast.makeText(MainActivity.this, "Values Persisted", Toast.LENGTH_LONG).show();
            }
        });
    }
    public void populate(){
        String persistedValue = prefs.getString("edit","Nothing Persisted Yet");
        boolean checked = prefs.getBoolean("check",false);
        text.setText(persistedValue);
        check.setChecked(checked);
    }
}












