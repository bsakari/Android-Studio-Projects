package com.king.deltapreferences;

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
    EditText txtPersist;
    CheckBox checkPersist;
    SharedPreferences prefs;
    SharedPreferences.Editor edits;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        persistValues = (Button) findViewById(R.id.persistValues);
        txtPersist = (EditText) findViewById(R.id.persistTextEdt);
        checkPersist = (CheckBox) findViewById(R.id.checkPersistState);
        prefs = getSharedPreferences("view",0);
        edits = prefs.edit();
        populate();
        persistValues.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edits.putString("txtVal",txtPersist.getText().toString());
                edits.putBoolean("checkState",checkPersist.isChecked());
                edits.commit();
                Toast.makeText(MainActivity.this, "Value Persisted", Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void populate(){
        String persistedText = prefs.getString("txtVal","Nothing Persisted Yet");
        boolean isChecked = prefs.getBoolean("checkState",false);
        txtPersist.setText(persistedText);
        checkPersist.setChecked(isChecked);
    }
}
