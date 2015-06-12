package com.shadow.zyw.sdu.chapter06;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;


public class RememberPswActivity extends ActionBarActivity {
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;
    private EditText name;
    private EditText psw;
    private Button login;
    private CheckBox save_psw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remember_psw);
        name = (EditText) findViewById(R.id.login_name);
        psw = (EditText) findViewById(R.id.login_psw);
        login = (Button) findViewById(R.id.login_btn);
        save_psw = (CheckBox) findViewById(R.id.save_psw);

        preferences = getSharedPreferences("users", MODE_PRIVATE);
        if (preferences.getBoolean("save", false)) {
            name.setText(preferences.getString("name",""));
            psw.setText(preferences.getString("psw",""));
            save_psw.setChecked(true);
        }
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (String.valueOf(name.getText()).equals("admin") && String.valueOf(psw.getText()).equals("123")) {
                    editor = preferences.edit();
                    if (save_psw.isChecked()) {
                        editor.putString("name", String.valueOf(name.getText()));
                        editor.putString("psw", String.valueOf(psw.getText()));
                        editor.putBoolean("save", true);
                    } else {
                        editor.clear();
                        Log.d("test", "clear");
                    }
                    editor.commit();
                    Intent intent = new Intent(RememberPswActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(RememberPswActivity.this, "wrong",Toast.LENGTH_SHORT).show();
                }


            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_remember_psw, menu);
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
