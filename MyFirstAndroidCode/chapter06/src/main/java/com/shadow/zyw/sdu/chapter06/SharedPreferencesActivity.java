package com.shadow.zyw.sdu.chapter06;

import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.HashSet;
import java.util.Set;


public class SharedPreferencesActivity extends ActionBarActivity {
    private Button saveData;
    private Button loadData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preferences);
        saveData = (Button) findViewById(R.id.shared_save);
        saveData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = getSharedPreferences("shared_data", MODE_PRIVATE).edit();
                editor.putString("name", "admin");
                editor.putString("psw", "123");
                editor.putBoolean("boolean_value", true);
                Set<String> set = new HashSet<String>();
                set.add("a");
                set.add("b");
                editor.putStringSet("setString", set);
                editor.commit();
            }
        });
        loadData = (Button) findViewById(R.id.shared_load);
        loadData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences preferences = getSharedPreferences("shared_data", MODE_PRIVATE);
                String name = preferences.getString("name","");
                Toast.makeText(SharedPreferencesActivity.this, name,Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_shared_preferences, menu);
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
