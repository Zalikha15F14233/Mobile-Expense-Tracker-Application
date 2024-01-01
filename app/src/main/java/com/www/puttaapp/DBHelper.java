package com.www.puttaapp;// package name

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper
{
    // here is the database table with its defined columns.
    public static final String DATABASE_NAME="15F14233.db";// This is the database name called 15F14233
    public static final String TABLE_NAME="Expense_Tracker_App";// This is table named Expense_Tracker_App.
    // below we declared and set all possible columns in table ARNOLD_GYM_MEMBERS.
    public static final String COL_1="fn7200";
    public static final String COL_2="ln7200";
    public static final String COL_3="phone7200";
    public static final String COL_4="member7200";
    public static final String COL_5="Cost1";

    public DBHelper(Context context)
    {
        super(context,DATABASE_NAME,null,1);// / Here we uses DB helper for context from 15F14233.db.
    }
    public void onCreate(SQLiteDatabase db)// created table on DB
    {
        db.execSQL("create table " +TABLE_NAME+ "(fn7200 TEXT,ln7200 TEXT,phone7200 INTEGER, member7200 INTEGER, Cost1 INTEGER)");
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
    // below method is to inserting data to the DB that created in table ARNOLD_GYM_MEMBERS.
    public boolean insertData(String fn7200, String ln7200, String phone7200, String member7200, String Cost1)
    {
        // below, we read all the context in DB table columns.
        SQLiteDatabase db=this.getReadableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(COL_1,fn7200);
        contentValues.put(COL_2,ln7200);
        contentValues.put(COL_3,phone7200);
        contentValues.put(COL_4,member7200);
        contentValues.put(COL_4,Cost1);
        long result=db.insert(TABLE_NAME,null,contentValues);
        if(result==-1)
            return false;
        else
            return true;
    }

    // below method is to update the data in the DB table named Expense_Tracker_App.
    public boolean updateData(String fn7200, String ln7200, String phone7200, String member7200)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(COL_1,fn7200);
        contentValues.put(COL_2,ln7200);
        contentValues.put(COL_3,phone7200);
        contentValues.put(COL_4,member7200);
        db.update(TABLE_NAME,contentValues,"phone720=?",new String[]{phone7200});
        return true;
    }

    public Integer deleteData(String phone7200)// method to remove all the data in ARNOLD_GYM_MEMBERS table and that depending to the phone number.
    {
        SQLiteDatabase db=this.getWritableDatabase();
        return db.delete(TABLE_NAME,"phone7200=?",new String[]{phone7200});
    }

    public Cursor getAllData() // this method is to read and view the data in ARNOLD_GYM_MEMBERS table.
    {
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor=db.rawQuery("select * from " +TABLE_NAME,null);
        return cursor;
    }

}





