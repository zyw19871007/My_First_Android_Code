package com.shadow.zyw.sdu.chapter09;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

/**
 * Created by shadow on 2015/6/16.
 */
public class MyService extends Service{
    private DownloadBinder myBinder = new DownloadBinder();
    @Override
    public IBinder onBind(Intent intent) {
        return myBinder;
    }

    class DownloadBinder extends Binder{
        public void startDownload() {
            Log.d("test", "start download");
        }

        public int getProgress() {
            Log.d("test", "getProgress");
            return 0;
        }

    }
    @Override
    public void onDestroy() {
        super.onDestroy();

        Log.d("test", "stop");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("test", "start command");
        return super.onStartCommand(intent, flags, startId);
    }

    @SuppressLint("NewApi")
    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("test", "start");
        Notification.Builder builder = new Notification.Builder(this);
        builder.setContentText("content jfalfja");
        builder.setContentTitle("title dfa");
        builder.setSmallIcon(R.mipmap.ic_launcher);
        startForeground(1,builder.build());
    }
}
