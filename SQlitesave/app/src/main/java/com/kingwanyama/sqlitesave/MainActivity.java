package com.kingwanyama.sqlitesave;

import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText cid,cname,camount;
    Button save;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cid = (EditText) findViewById(R.id.cid);
        cname = (EditText) findViewById(R.id.cname);
        camount = (EditText) findViewById(R.id.camount);
        result = (TextView) findViewById(R.id.risalt);
        save = (Button) findViewById(R.id.save);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cid.getText().toString().length()<1)
                {
                    cid.setError("ERROR! Enter ID");
                }
                else if (cname.getText().toString().length()<1)
                {
                    cname.setError("ERROR! Enter Name");
                }
                else if (camount.getText().toString().length()<1)
                {
                    camount.setError("ERROR! Enter Amount");
                }
                else
                    {
                        SQLiteHelper b = new SQLiteHelper(MainActivity.this);
                        b.Save(cid.getText().toString(),cname.getText().toString(),camount.getText().toString());
                        cid.setText("");
                        cname.setText("");
                        camount.setText("");
                    }

            }
        });



    }

}
