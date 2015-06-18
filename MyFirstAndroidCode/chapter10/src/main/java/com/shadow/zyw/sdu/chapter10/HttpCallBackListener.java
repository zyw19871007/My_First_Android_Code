package com.shadow.zyw.sdu.chapter10;

/**
 * Created by shadow on 2015/6/18.
 */
public interface HttpCallBackListener {
    void onFinish(String response);

    void onError(Exception e);
}
