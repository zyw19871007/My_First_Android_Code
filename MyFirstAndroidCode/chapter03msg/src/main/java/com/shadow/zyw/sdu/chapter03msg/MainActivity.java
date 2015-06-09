package com.shadow.zyw.sdu.chapter03msg;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity {
    private EditText editText;
    private Button btn;
    private List<Msg> list = new ArrayList<>();
    private ListView listView;
    private MsgAdapter msgAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String data[] = {"a", "a1", "f", "b", "c", "sfa", "xvx",};
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
        listView = (ListView) findViewById(R.id.listview);
        msgAdapter = new MsgAdapter(this, R.layout.list_item,list);
        listView.setAdapter(msgAdapter);

        editText = (EditText) findViewById(R.id.msg_edit);
        btn = (Button) findViewById(R.id.msg_btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = String.valueOf(editText.getText());
                Msg msg1 = new Msg(str,Msg.SEND);
                list.add(msg1);
                msgAdapter.notifyDataSetChanged();
                editText.setText("");
                listView.setSelection(list.size());

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
