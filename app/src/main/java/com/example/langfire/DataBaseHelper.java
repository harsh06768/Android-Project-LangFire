package com.example.langfire;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DataBaseHelper extends SQLiteOpenHelper {
    public static final String dbnam = "register.db";
    public static final String tabnam = "regter";
    public static final String col1 = "ID";
    public static final String col2 = "username";
    public static final String col3 = "password";

    public DataBaseHelper(@Nullable Context context) {
        super(context, dbnam, null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE regter (ID INTEGER PRIMARY KEY AUTOINCREMENT, username TEXT,password TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(" DROP TABLE IF EXISTS " + tabnam);
        onCreate(db);
    }
    public void setName(String user,String password)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv= new ContentValues();
        cv.put("username",user);
        cv.put("password",password);
        long res = db.insert("regter",null,cv);
    }
    public Cursor getName()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c = db.rawQuery("select * from "+tabnam,null);
        return c;
    }
}
