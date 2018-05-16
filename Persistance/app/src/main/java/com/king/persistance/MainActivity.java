package com.king.persistance;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button persistValues;
    EditText textPersist;
    CheckBox checkPersist;
    SharedPreferences prefs;
    SharedPreferences.Editor edits;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        persistValues = (Button) findViewById(R.id.persistValues);
        textPersist = (EditText) findViewById(R.id.persistTextEdt);
        checkPersist = (CheckBox) findViewById(R.id.checkPersistState);
        prefs = getSharedPreferences("view",0);
        edits = prefs.edit();
        populate();
        persistValues.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edits.putString("txtVal",textPersist.getText().toString());
                edits.putBoolean("isChecked",checkPersist.isChecked());
                edits.commit();
                Toast.makeText(MainActivity.this, "Values Persisted", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void populate() {
        String persistedTxt = prefs.getString("txtVal","Nothing Persisted Yet");
        boolean isChecked = prefs.getBoolean("isChecked",false);
        textPersist.setText(persistedTxt);
        checkPersist.setChecked(isChecked);
    }
}









