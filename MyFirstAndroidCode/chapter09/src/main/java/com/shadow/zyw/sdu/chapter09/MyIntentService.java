package com.shadow.zyw.sdu.chapter09;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

/**
 * Created by shadow on 2015/6/16.
 */
public class MyIntentService extends IntentService{
    public MyIntentService() {
        super("myinserv");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("test", "myintentservice destroy");

    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Log.d("test", String.valueOf(Thread.currentThread().getId()));


    }
}
