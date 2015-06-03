package com.shadow.zyw.sdu.chapter02;

import android.animation.IntEvaluator;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class ToastActivity extends ActionBarActivity {
    private Button btn;
    static ToastActivity toastActivity;

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        String stemp = "save_str";
        outState.putString("save",stemp);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                String datas = data.getStringExtra("text");
                Log.v("text", datas);
                TextView tv = (TextView) findViewById(R.id.toast_tv);
                tv.setText(datas);
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast);
        toastActivity = this;
        if (savedInstanceState != null) {
            Log.d("text", savedInstanceState.getString("save"));
        }
        Log.e("text", getClass().getSimpleName());
        btn = (Button) findViewById(R.id.toastId);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ToastActivity.this, "lalalla", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(ToastActivity.this, IntentViewActivity.class);
                intent.putExtra("intent", "sdfsf");
//                Intent intent = new Intent("intent_test");
//                intent.addCategory("intent_test_category");
//                Intent intent = new Intent(Intent.ACTION_VIEW);
//                intent.setData(Uri.parse("http://www.baidu.com"));
//                Intent intent = new Intent(Intent.ACTION_DIAL);
//                intent.setData(Uri.parse("tel:10086"));

//                startActivity(intent);
                startActivityForResult(intent,1);


            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_toast, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        Toast.makeText(this, item.getTitle(),Toast.LENGTH_SHORT).show();
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
