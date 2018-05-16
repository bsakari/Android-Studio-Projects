package com.kingwanyama.sqlitesave;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Created by kingwanyama on 12/19/17.
 */

class SQLiteHelper extends SQLiteOpenHelper {
    String data;
    Context context;
    public SQLiteHelper(Context c) {

        super(c, "wewe", null, 1);
        this.context=c;
    }

    SQLiteDatabase db;
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS clients(id INT(50),names TEXT(50),amount INT(50));");

    }

    public void Save(String id,String name, String amount)
    {
        db = this.getWritableDatabase();
        ContentValues c = new ContentValues();
        c.put("id",id);
        c.put("names",name);
        c.put("amount",amount);

        long x = db.insert("clients",null,c);

        if (x==0)
        {
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(context, "Saved Successfully", Toast.LENGTH_SHORT).show();
        }
    }


    public String Search_(String cid)
    {
        db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM tasks", null);
        if (cursor.getCount()<1)
        {
            Toast.makeText(context, "No Record", Toast.LENGTH_SHORT).show();
        }
        else if (cursor.getCount()>0)

        {
            while(cursor.moveToNext())
            {
                String event = cursor.getString(0);
                String desc = cursor.getString(1);
                data+= "Event : "+event+"\n Desc "+ desc;
            }
        }
        else
        {
            Toast.makeText(context, "Contact Admin", Toast.LENGTH_SHORT).show();
        }
        return data;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}


