package com.shadow.zyw.sdu.chapter03listview;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity {
    private ListView listView;
    private List<Fruit> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.list_view);
//        String data[] = {"a", "b", "c","d","e","f","f","f","f","f","f","f","v"};
//        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,data);
//        listView.setAdapter(adapter);
        Fruit fruit = new Fruit("a",1);
        list.add(fruit);
        fruit = new Fruit("banana",2);
        list.add(fruit);
        fruit = new Fruit("canana",3);
        list.add(fruit);
        fruit = new Fruit("danana",4);
        list.add(fruit);
        fruit = new Fruit("danana",4);
        list.add(fruit);
        fruit = new Fruit("danana",4);
        list.add(fruit);
        fruit = new Fruit("danana",4);
        list.add(fruit);
        fruit = new Fruit("danana",4);
        list.add(fruit);
        fruit = new Fruit("danana",4);
        list.add(fruit);
        fruit = new Fruit("dsafdas",111);
        list.add(fruit);
        FruitAdapter fruitAdapter = new FruitAdapter(this,R.layout.fruit_item,list);
        listView.setAdapter(fruitAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Fruit fruit1;
                fruit1 = list.get(position);
                Toast.makeText(MainActivity.this, fruit1.getName()+fruit1.getId(),Toast.LENGTH_SHORT).show();
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
