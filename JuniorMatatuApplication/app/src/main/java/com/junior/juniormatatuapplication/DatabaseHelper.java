package com.junior.juniormatatuapplication;

/**
 * Created by emobilis on 4/13/18.
 */


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by kingwanyama on 4/13/18.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "Matatu.db";
    public static final String TABLE_NAME = "Matatu_table";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "PLATE";
    public static final String COL_3 = "NAME";
    public static final String COL_4 = "VACANCY";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME +"(ID INTEGER PRIMARY KEY AUTOINCREMENT,PLATE INTEGER,NAME TEXT,VACANCY INTEGER)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }
    public boolean insertData(String plate,String name, String vacancy  ){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2,plate);
        contentValues.put(COL_3,name);
        contentValues.put(COL_4,vacancy);
        long result = db.insert(TABLE_NAME,null,contentValues);
        if (result==-1)
            return false;
        else

            return true;

    }
    //Method to fetch
    public Cursor getAllData(){


        SQLiteDatabase  db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+ TABLE_NAME,null);
        return  res;
    }
}

