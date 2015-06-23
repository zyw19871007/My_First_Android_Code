package com.shadow.zyw.sdu.chapter13;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(MyApplication.getContext(),"afdaf",Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, SecondActivity.class);
        Person person = new Person();
        person.setAge(12);
        person.setName("shadow");
        PersonParcel personParcel = new PersonParcel();
        personParcel.setName("bajie");
        personParcel.setAge(333);
        intent.putExtra("data", person);
        intent.putExtra("data_parcel", personParcel);
//        startActivity(intent);
        textView = (TextView) findViewById(R.id.test_name);
        textView.setText("test test test");

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
