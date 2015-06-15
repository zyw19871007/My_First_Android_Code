package com.shadow.zyw.sdu.chapter06sqlite;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends ActionBarActivity {
    private Button button;
    private MyDataBaseHelper dataBaseHelper;
    private Button add;
    private Button update;
    private Button delete;
    private Button query;
    private Button replace;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.create_db);
        dataBaseHelper = new MyDataBaseHelper(MainActivity.this,"my_database",null,2 );
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dataBaseHelper.getWritableDatabase();
            }
        });
        add = (Button) findViewById(R.id.add_data);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = dataBaseHelper.getWritableDatabase();
                ContentValues contentValues = new ContentValues();
                contentValues.put("name","shadow_01");
                contentValues.put("price",19.03);
                db.insert("book",null,contentValues);
            }
        });
        update = (Button) findViewById(R.id.update_data);
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = dataBaseHelper.getWritableDatabase();
                ContentValues contentValues = new ContentValues();
                contentValues.put("name","shadow_update01");
                contentValues.put("price",112);
                db.update("book", contentValues, "id=?", new String[]{"1"});
            }
        });
        delete = (Button) findViewById(R.id.delete_data);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = dataBaseHelper.getWritableDatabase();
                db.delete("book", "id=?", new String[]{"2"});
            }
        });
        query = (Button) findViewById(R.id.query_data);
        query.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = dataBaseHelper.getWritableDatabase();
               Cursor cursor =  db.query("book", null, "id >?", new String[]{"2"}, null, null, null);
                cursor.moveToFirst();
                while (!cursor.isAfterLast()) {
                    int id = cursor.getInt(cursor.getColumnIndex("id"));
                    Log.d("test", String.valueOf(id));
                    cursor.moveToNext();
                }
                cursor.close();

            }
        });
        replace = (Button) findViewById(R.id.replace_data);
        replace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = dataBaseHelper.getWritableDatabase();
                db.beginTransaction();
                try {
                    db.delete("book", null, null);
                    if (false) {
                        throw new NullPointerException();
                    }
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("name", "replace_01");
                    db.insert("book", null, contentValues);
                    db.insert("book", null, contentValues);
                    db.setTransactionSuccessful();
                } catch (NullPointerException e) {
                    e.printStackTrace();

                }
                finally {
                    db.endTransaction();
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
