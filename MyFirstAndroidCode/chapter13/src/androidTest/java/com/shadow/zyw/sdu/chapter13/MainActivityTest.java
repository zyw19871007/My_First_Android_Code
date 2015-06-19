package com.shadow.zyw.sdu.chapter13;

import android.test.ActivityInstrumentationTestCase2;
import android.test.InstrumentationTestCase;

/**
 * Created by shadow on 2015/6/19.
 */
public class MainActivityTest extends ActivityInstrumentationTestCase2<MainActivity>{

    public MainActivityTest() {
        super(MainActivity.class);
    }

    @Override
    public void setUp() throws Exception {
        super.setUp();
    }

    public void testadd() {
        assertEquals(1,2);
    }
}
