package com.shadow.zyw.sdu.chapter09timerservice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by shadow on 2015/6/16.
 */
public class AlarmService extends BroadcastReceiver{
    @Override
    public void onReceive(Context context, Intent intent) {
        Intent it = new Intent(context, LongRunningService.class);
        context.startService(it);
        Log.d("test", "alarm service");
    }
}
