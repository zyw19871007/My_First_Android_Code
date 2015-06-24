package com.shadow.zyw.sdu.fragmenttabs;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.renderscript.Sampler;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;


public class MainActivity extends ActionBarActivity implements View.OnClickListener {

    String btns[] = {"message", "contacts", "news", "setting"};
    private Map<String, String> map = new HashMap<>();
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager = getFragmentManager();
        for (int i = 0; i < btns.length; i++) {
            View view = findView(btns[i] + "_layout", "id");
            map.put(String.valueOf(view.getId()), btns[i]);
            view.setOnClickListener(this);
        }
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

    @Override
    public void onClick(View v) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Log.d("test", String.valueOf(v.getId()));
        String name = map.get(String.valueOf(v.getId()));
        Log.d("test", "name" + name);
        Fragment fragment;
        try {
            fragment = (Fragment) newInstance(name + "Frag");
        } catch (Exception e) {
            e.printStackTrace();
            Log.d("test", "cannot create class:" + name);
            return;
        }
        ImageView imageView = (ImageView) findView(name + "_image", "id");
        int resid = findView(name + "_selected", "mipmap").getId();
        imageView.setImageResource(Integer.valueOf(resid));
        TextView textView = (TextView) findView(name + "_text", "id");
        textView.setTextColor(Color.WHITE);
        fragmentTransaction.add(R.id.content, fragment);
        if (fragment == null) {

        }
//        imageView.setImageResource(findImage(name+"_selected"));


    }

    private Integer findImage(String name) {
        Integer value = null;
        Class<R.mipmap> cls = R.mipmap.class;
        try {
            value = cls.getDeclaredField(name).getInt(null);
        } catch (Exception e) {
            Log.d("test", "findimage error" + name);
        }
        return value;

    }

    private View findView(String name, String type) {
        int resId = getResources().getIdentifier(name, type, "com.shadow.zyw.sdu.fragmenttabs");
        View view = (View) findViewById(resId);
        return view;
    }

    private static Object newInstance(String className) throws Exception {
        StringBuilder sb = new StringBuilder(className);
        sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));
        className = sb.toString();
        Log.d("test", "classname:" + className);
        Class clazz = Class.forName(className);

        return clazz.newInstance();

    }
}
