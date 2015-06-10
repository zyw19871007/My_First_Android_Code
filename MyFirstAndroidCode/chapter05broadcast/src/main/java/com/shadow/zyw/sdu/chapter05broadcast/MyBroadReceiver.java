package com.shadow.zyw.sdu.chapter05broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by shadow on 2015/6/10.
 */
public class MyBroadReceiver extends BroadcastReceiver{
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "my broadReciever", Toast.LENGTH_SHORT).show();
        abortBroadcast();
    }
}
