package com.junior.juniormatatuapplication;

import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.lang.reflect.Method;

public class Fleet extends AppCompatActivity {
    DatabaseHelper myDb;
    EditText editNp,editCn,editCc;
    Button btnAddData,btnView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fleet);
        myDb=new DatabaseHelper(this);
        editNp=findViewById(R.id.edt1);
        editCn=findViewById(R.id.edt2);
        editCc=findViewById(R.id.edt3);
        btnAddData=findViewById(R.id.btnadd);
        btnView=findViewById(R.id.btnview);
            }

    //Add data method
    public void AddData(View view) {
        boolean isInserted= myDb.insertData(editNp.getText().toString(),
                editCn.getText().toString(),editCc.getText().toString());
        if (isInserted==true){
            Toast.makeText(Fleet.this, "Success", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(Fleet.this, "Fail", Toast.LENGTH_SHORT).show();
        }
    }
    //End of add data method




    //showMessage Method for the display dialog
    private void showMessage(String title, String message) {
        AlertDialog.Builder builder= new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }

        //View Data Method
    public void ViewAll(View view) {

        Cursor res= myDb.getAllData();
        if (res.getCount()==0){
            showMessage("Error","Nothing Found");
            return;
        }
        StringBuffer buffer= new StringBuffer();
        while(res.moveToNext()){
            buffer.append("Number Plate: "+res.getString(0)+"\n");
            buffer.append("Car Name: "+res.getString(1)+"\n");
            buffer.append("Carrying Capacity: "+res.getString(2)+"\n");
        }
        showMessage("Umoinner",buffer.toString());

    }
    //End of view data method
}
