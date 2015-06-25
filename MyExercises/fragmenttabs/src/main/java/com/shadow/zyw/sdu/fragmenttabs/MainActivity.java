package com.shadow.zyw.sdu.fragmenttabs;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Color;
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
    Fragment fragment;
    FragInterface fragInterface;
    String tabs[] = {"message", "contacts", "news", "setting"};
    private Map<String, String> map = new HashMap<>();
    private Map<String, Fragment> fragmentMap = new HashMap<>();
    private FragmentManager fragmentManager;
    private FragObject fragObject;



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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager = getFragmentManager();
        for (int i = 0; i < tabs.length; i++) {
            View view = findView(tabs[i] + "_layout", "id");
            map.put(String.valueOf(view.getId()), tabs[i]);
            view.setOnClickListener(this);
        }
        setSelected(tabs[0]);
    }

    @Override
    public void onClick(View v) {
        Log.d("test", String.valueOf(v.getId()));
        String name = map.get(String.valueOf(v.getId()));
        Log.d("test", "name" + name);

        clearSelected();
        setSelected(name);

    }

    private void clearSelected() {
        for (int i = 0; i < tabs.length; i++) {
            ImageView imageView = (ImageView) findView(tabs[i] + "_image", "id");
            imageView.setImageResource(findImage(tabs[i] + "_unselected"));
            TextView textView = (TextView) findView(tabs[i] + "_text", "id");
            textView.setTextColor(Color.parseColor("#82858b"));
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            if (fragmentMap.get(tabs[i]) != null) {
                fragmentTransaction.hide(fragmentMap.get(tabs[i]));
            }

            fragmentTransaction.commit();

        }
    }

    private void setSelected(String name) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        if (fragmentMap.get(name) == null) {
            try {
                fragment = (Fragment) newInstance(name + "Frag");
                fragInterface = (FragInterface) newInstance(name + "Frag");

            } catch (Exception e) {
                e.printStackTrace();
                Log.d("test", "cannot create class:" + name);
                return;
            }
            fragmentMap.put(name, fragment);
            fragmentTransaction.add(R.id.content, fragment);
        } else {
            fragment = fragmentMap.get(name);
            fragmentTransaction.show(fragment);
        }
        fragmentTransaction.commit();
        ImageView imageView = (ImageView) findView(name + "_image", "id");
        imageView.setImageResource(findImage(name + "_selected"));
        TextView textView = (TextView) findView(name + "_text", "id");
        textView.setTextColor(Color.WHITE);
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
        Log.d("test", "find view:" + name + resId);
        View view = (View) findViewById(resId);
        return view;
    }

    private static Object newInstance(String className) throws Exception {
        StringBuilder sb = new StringBuilder(className);
        sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));
        className = sb.toString();
        Log.d("test", "classname:" + className);
        Class clazz = Class.forName("com.shadow.zyw.sdu.fragmenttabs." + className);
        return clazz.newInstance();

    }
}
