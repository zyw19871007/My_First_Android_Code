package com.shadow.zyw.sdu.chapter03;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {
    private TextView tv;
    private EditText et;
    private Button btn;
    private ProgressBar pb;
    private Button btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = (TextView) findViewById(R.id.main_textv);
        et = (EditText) findViewById(R.id.main_et);
        btn = (Button) findViewById(R.id.main_btn);
        btn2 = (Button) findViewById(R.id.main_btn2);
        pb=(ProgressBar)findViewById(R.id.main_pb);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv.setText(tv.getText().toString() + et.getText());
                int progress = pb.getProgress();
                progress+=10;
                pb.setProgress(progress);
                AlertDialog.Builder ad = new AlertDialog.Builder(MainActivity.this);
                ad.setTitle("biaoti");
                ad.setMessage("msg:hello");

                ad.setCancelable(false);
                ad.setOnCancelListener(new DialogInterface.OnCancelListener() {
                    @Override
                    public void onCancel(DialogInterface dialog) {
                        Toast.makeText(MainActivity.this, "cancle_true",Toast.LENGTH_SHORT).show();
                    }
                });
                ad.setNegativeButton("cancle_la", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "canclecancle",Toast.LENGTH_SHORT).show();
                    }
                });
                ad.setPositiveButton("im sure", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "okokok", Toast.LENGTH_SHORT).show();
                    }
                });
                ad.show();


            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProgressDialog pd = new ProgressDialog(MainActivity.this);
                pd.setTitle("title");
                pd.setMessage("loading");
                pd.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                pd.setProgress(12);
                pd.show();
                pd.setProgress(12);
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
