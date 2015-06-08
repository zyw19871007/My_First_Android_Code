package com.shadow.zyw.sdu.chapter03msg;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String data[] = {"a", "a1", "f", "b", "c", "sfa", "xvx",};
        List<Msg> list = new ArrayList<>();
        Msg msg = new Msg("a",Msg.RECEIVE);
        list.add(msg);
        msg = new Msg("b", Msg.SEND);
        list.add(msg);
        msg = new Msg("asfsf", Msg.RECEIVE);
        list.add(msg);
        msg = new Msg("bsafas", Msg.SEND);
        list.add(msg);
        msg = new Msg("kjga", Msg.RECEIVE);
        list.add(msg);
        ListView listView = (ListView) findViewById(R.id.listview);
        MsgAdapter msgAdapter = new MsgAdapter(this, R.layout.list_item,list);
        listView.setAdapter(msgAdapter);

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
