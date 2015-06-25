package com.shadow.zyw.sdu.fragmenttabs;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by shadow on 2015/6/24.
 */
public class ContactsFrag extends Fragment implements FragInterface{
    private  static ContactsFrag contactsFrag=null;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.contacts_layout, container, false);
        return view;
    }
    public static ContactsFrag newInstance() {
        if (contactsFrag == null) {
            contactsFrag = new ContactsFrag();
        }
        Log.d("test", "contact instance");
        return contactsFrag;
    }


}
