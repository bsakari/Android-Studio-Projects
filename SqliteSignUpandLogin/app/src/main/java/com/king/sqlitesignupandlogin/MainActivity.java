package com.king.sqlitesignupandlogin;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper myDb;
    SQLiteOpenHelper openHelper;
    SQLiteDatabase db;
    Button _btnreg, _btnlogin,_btnViewAll;
    EditText _txtfname,_txtlname,_txtpass,_txtemail,_txtphone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDb = new DatabaseHelper(this);
        openHelper = new DatabaseHelper(this);
        _btnlogin = (Button) findViewById(R.id.btnlogin);
        _btnreg = (Button) findViewById(R.id.btnreg);
        _btnViewAll = (Button) findViewById(R.id.btnView);
        _txtfname = (EditText) findViewById(R.id.txtfname);
        _txtlname = (EditText) findViewById(R.id.txtlname);
        _txtpass = (EditText) findViewById(R.id.txtpass);
        _txtemail = (EditText) findViewById(R.id.txtemail);
        _txtphone = (EditText) findViewById(R.id.txtphone);
        _btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),login.class);
                startActivity(intent);
            }
        });
        _btnreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db = openHelper.getWritableDatabase();
                String fname = _txtfname.getText().toString().trim();
                String lname = _txtlname.getText().toString().trim();
                String pass = _txtpass.getText().toString().trim();
                String email = _txtemail.getText().toString().trim();
                String phone = _txtphone.getText().toString().trim();
                insertdata(fname,lname,pass,email,phone);
                Toast.makeText(MainActivity.this, "Registration Successful", Toast.LENGTH_SHORT).show();
                _txtfname.setText("");
                _txtlname.setText("");
                _txtpass.setText("");
                _txtemail.setText("");
                _txtphone.setText("");
            }
        });
        _btnViewAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Cursor res =  myDb.getAllData();
                if (res.getCount()==0){
                    //Show Message
                    showMessage("Error","Nothing Found");
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while (res.moveToNext()){
                    buffer.append("Id: "+res.getString(0)+"\n");
                    buffer.append("First Name: "+res.getString(1)+"\n");
                    buffer.append("Last Name: "+res.getString(2)+"\n");
                    buffer.append("Password: "+res.getString(3)+"\n");
                    buffer.append("eMail: "+res.getString(4)+"\n");
                    buffer.append("Phone: "+res.getString(5)+"\n\n");

                }
                showMessage("Data",buffer.toString());
            }
        });

    }



    public void insertdata(String fname,String lname,String pass,
                           String email,String phone){
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelper.COL_2,fname);
        contentValues.put(DatabaseHelper.COL_3,lname);
        contentValues.put(DatabaseHelper.COL_4,pass);
        contentValues.put(DatabaseHelper.COL_5,email);
        contentValues.put(DatabaseHelper.COL_6,phone);
        long id = db.insert(DatabaseHelper.TABLE_NAME,null,contentValues);
    }
    public void showMessage(String title, String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();

    }


}
