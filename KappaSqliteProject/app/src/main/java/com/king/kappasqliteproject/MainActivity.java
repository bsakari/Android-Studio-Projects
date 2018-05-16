package com.king.kappasqliteproject;

import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper myDb;
    EditText editName,editSurname,editMarks;
    Button btnAddData,btnView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDb = new DatabaseHelper(this);
        editName = (EditText) findViewById(R.id.edt1);
        editSurname = (EditText) findViewById(R.id.edt2);
        editMarks = (EditText) findViewById(R.id.edt3);
        btnAddData = (Button) findViewById(R.id.btnadd);
        btnView = (Button) findViewById(R.id.btnView);
        AddData();
        viewAll();
    }

    //Method for Inserting Students
    public void AddData(){
        btnAddData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isInserted = myDb.insertData(editName.getText().toString(),
                        editSurname.getText().toString(),editMarks.getText().toString());
                if (isInserted==true){
                    Toast.makeText(MainActivity.this, "Student Inserted Successfully", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(MainActivity.this, "Failed To Insert The Student", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    //End of method AddData


    //Method for Fetching Students
    public void viewAll(){
        btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor res = myDb.getAllData();
                if (res.getCount()==0){
                    showMessage("Error","Nothing Found");
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while (res.moveToNext()){
                    buffer.append("Id "+res.getString(0)+"\n");
                    buffer.append("First Name "+res.getString(1)+"\n");
                    buffer.append("Last Name "+res.getString(2)+"\n");
                    buffer.append("Marks "+res.getString(3)+"\n\n");
                }
                showMessage("Data",buffer.toString());
            }
        });
    }
    //End of method viewAll

    //Start of showMessage method
    public void showMessage(String title,String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }
}







