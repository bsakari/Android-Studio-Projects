package com.kingwanyama.sqlliteproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Created by developer on 8/1/2017.
 */


//http://192.168.88.48/android

public class SQLiteHelper extends SQLiteOpenHelper {
    //create a constructor
   String data;//store data later
    Context context;//global declared
    public SQLiteHelper(Context c){
         //create the database
        super(c,"msaccodb",null,1);
                //db            //version
        this.context=c;
    }




    SQLiteDatabase db;
    @Override
    public void onCreate(SQLiteDatabase db) {
       // db=db;
        db.execSQL("CREATE TABLE IF NOT EXISTS clients(id INT(50),names TEXT(50),amount INT(50));");
    }




    //SAVE===============================================
    public void Save(String id,String name,String amount){
        //let save
        db = this.getWritableDatabase();
        ContentValues c = new ContentValues();
        //key value
        //These in green are table columns-check line 35
        //Those in black are the strings in line 42
        c.put("id",id);
        c.put("names",name);
        c.put("amount",amount);




        long x = db.insert("clients",null,c);//end
        //Toast.makeText(context, ""+x, Toast.LENGTH_SHORT).show();
        if (x==0){
            Toast.makeText(context, "Failed!", Toast.LENGTH_SHORT).show();
        }

        else
        {
            Toast.makeText(context, "Saved!", Toast.LENGTH_SHORT).show();

        }

    }//end















    //CRUD
    
    //method to search===============================
    public String Search(String cid){
        db= this.getReadableDatabase();//permissions
        //query. SQL
        // //rawQuery should return results
        Cursor cursor = db.rawQuery("SELECT *  FROM tasks" ,null);
        //cursor has the rows
        if (cursor.getCount()<1){//count rows
            Toast.makeText(context, "No Records", Toast.LENGTH_SHORT).show();
        }
        else if(cursor.getCount()>0){
            //get data.
            while (cursor.moveToNext()){
                //4 one row
                String event = cursor.getString(0);
                String desc = cursor.getString(1);

                //update data for each row
                data+="Event : "+event+" \n Desc "+ desc;

            }//end while

        }//end
        else {
            Toast.makeText(context, "Contact Admin", Toast.LENGTH_SHORT).show();
        }//else


        return data;//return data
    }//end
    
    
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    //CRUD

}//end





