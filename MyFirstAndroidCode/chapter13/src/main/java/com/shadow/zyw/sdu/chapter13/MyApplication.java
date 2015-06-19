package com.shadow.zyw.sdu.chapter13;

import android.app.Application;
import android.content.Context;

/**
 * Created by shadow on 2015/6/18.
 */
public class MyApplication extends Application{
    private static Context context;

    public static Context getContext() {
        return context;
    }

    @Override
    public void onCreate() {
        context = getApplicationContext();

    }
}
