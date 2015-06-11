package com.shadow.zyw.sdu.chapter05forcelogoff;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by shadow on 2015/6/11.
 */
public class BaseActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityCollector.addActivity(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityCollector.removeActivity(this);
    }
}
