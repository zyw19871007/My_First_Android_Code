package com.shadow.zyw.sdu.fragmenttabs;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.util.Xml;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by shadow on 2015/6/25.
 */
public class FragObject extends Fragment{
    public String getXml() {
        return xml;
    }

    public void setXml(String xml) {
        this.xml = xml;
    }

    private String xml;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(findLayout(xml), container, false);
        Log.d("test", "frag create" + xml);
        return view;
    }
    private Integer findLayout(String name) {
        Integer value = null;
        Class<R.layout> cls = R.layout.class;
        try {
            value = cls.getDeclaredField(name).getInt(null);
        } catch (Exception e) {
            Log.d("test", "findlayout error" + name);
        }
        return value;

    }

}
