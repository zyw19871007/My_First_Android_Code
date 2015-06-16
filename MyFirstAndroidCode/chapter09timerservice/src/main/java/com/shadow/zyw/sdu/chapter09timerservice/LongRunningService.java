package com.shadow.zyw.sdu.chapter09timerservice;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.SystemClock;
import android.util.Log;

import java.util.Date;

/**
 * Created by shadow on 2015/6/16.
 */
public class LongRunningService extends Service{
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Log.d("test", "thread:"+new Date().toString());


            }
        }).start();
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        Intent it = new Intent(this,AlarmService.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 0, it, 0);
        alarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis()+10000,pendingIntent);
        return super.onStartCommand(intent, flags, startId);


    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
