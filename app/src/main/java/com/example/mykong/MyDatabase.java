package com.example.mykong;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MyDatabase extends SQLiteOpenHelper {
    public static final String DataBaseName = "CWdb.db";
    public static final String TableName = "tb_user";
    public static final String Colum1 = "Id";
    public static final String Colum2 = "username";
    public static final String Colum3 = "password";
    public static final String Colum4 = "phone";
    public static final String Colum5 = "email";
    //Constructer method to send all param
    public MyDatabase( Context context) {
        super(context, DataBaseName, null, 1);
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table "+TableName+" " +
                "("+Colum1+" INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ""+Colum2+" TEXT," +
                ""+Colum3+" TEXT, " +
                ""+Colum4+" TEXT," +
                ""+Colum5+" TEXT )");
    }
    boolean InsertData (String username, String Password, String Phone, String Email){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues =new ContentValues();
        contentValues.put(Colum2,username);
        contentValues.put(Colum3,Password);
        contentValues.put(Colum4,Phone);
        contentValues.put(Colum5,Email);
        long myData;
        myData = sqLiteDatabase.insert(TableName,null,contentValues);
        if (myData == -1){
            return false;
        }else {
            return true;
        }
    }

    boolean Updatedata(int id, String username, String pass, String phone, String email){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Colum2,username);
        contentValues.put(Colum3,pass);
        contentValues.put(Colum4,phone);
        contentValues.put(Colum5,email);
        Cursor cursor = sqLiteDatabase.rawQuery("select * from "+TableName+" where "+Colum1+" = ? ", new String[]{Integer.toString(id)});
        if (cursor.getCount()>0) {
            long UpdateInfo = sqLiteDatabase.update(TableName, contentValues, ""+Colum1+" = ?",
                    new String[]{Integer.toString(id)});
            if (UpdateInfo == -1) {
                return false;
            } else {
                return true;
            }
        }else {
            return false;
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists "+TableName);
        onCreate(sqLiteDatabase);
    }
}