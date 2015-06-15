package com.shadow.zyw.sdu.chapter06sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Created by shadow on 2015/6/12.
 */
public class MyDataBaseHelper extends SQLiteOpenHelper{
    private Context myContext;


    public MyDataBaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        myContext = context;
    }

    private static final String create_book = "create table book(id integer primary key autoincrement,author text,price real,pages integer,name text)";
    private static final String create_category = "create table category(id integer primary key autoincrement,category_name text,category_code integer)";


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(create_book);
        db.execSQL(create_category);
        Toast.makeText(myContext, "create book",Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table  if exists book");
        db.execSQL("drop table  if exists category");
        onCreate(db);

    }
}
