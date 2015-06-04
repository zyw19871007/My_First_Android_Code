package com.shadow.zyw.sdu.chapter03;

import android.content.Context;
import android.support.v4.view.LayoutInflaterFactory;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

/**
 * Created by shadow on 2015/6/4.
 */
public class customize_layout extends LinearLayout {
    public customize_layout(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.customize_layout, this);

    }
}
