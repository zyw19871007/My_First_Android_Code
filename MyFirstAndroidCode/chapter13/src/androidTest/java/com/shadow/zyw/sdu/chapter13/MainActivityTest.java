package com.shadow.zyw.sdu.chapter13;

import android.test.ActivityInstrumentationTestCase2;
import android.test.InstrumentationTestCase;
import android.widget.TextView;

/**
 * Created by shadow on 2015/6/19.
 */
public class MainActivityTest extends ActivityInstrumentationTestCase2<MainActivity> {
    private MainActivity myActivity;
    private TextView textView;

    public MainActivityTest() {
        super(MainActivity.class);
    }

    @Override
    public void setUp() throws Exception {
        super.setUp();
        myActivity = getActivity();
        textView = (TextView) myActivity.findViewById(R.id.test_name);
    }

    public void testadd() {
        assertEquals(2, 2);
    }

    public void testTextView() throws Exception {
        assertEquals("test test test",textView.getText().toString());


    }
}
