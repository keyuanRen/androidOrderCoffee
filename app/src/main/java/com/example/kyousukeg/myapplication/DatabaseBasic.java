package com.example.kyousukeg.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.ContentObservable;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseBasic extends SQLiteOpenHelper {

    Boolean userLogin = false;

    public DatabaseBasic(Context context) {
        super(context, "Login.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create table user(username text primary key, email text, password text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists user");
    }

    //insert into database
    public boolean insert(String username, String email, String password)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username",username);
        contentValues.put("email",email);
        contentValues.put("password",password);
        long ins = db.insert("user",null,contentValues);
        if(ins == -1) return false;
        else return true;
    }

    //check if there has already a same user exist
    public Boolean checkIfUserExist(String username, String email)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * from user where username=? and email=?",new String[]{username,email});
        if(cursor.getCount()>0)
        {
            return false;
        }
        else
            return true;
    }

    //check the username and password for login
    public Boolean checkLogin(String username, String password)
    {
        userLogin = false;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * from user where username=? and password=?",new String[]{username,password});
        if(cursor.getCount() >0) {
            userLogin = true;
            return true;
        }
        else return false;
    }

    //get username from login user
//    public void getCurrentUsername()
//    {
//        SQLiteDatabase db = this.getReadableDatabase();
//        Cursor cursor = db.rawQuery("Select username from user where ")
//    }

}
