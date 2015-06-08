package com.shadow.zyw.sdu.chapter03msg;

/**
 * Created by shadow on 2015/6/8.
 */
public class Msg {
    public final static int RECEIVE = 0;
    public final static int SEND = 1;
    private String msg;
    private int type;

    public String getMsg() {
        return msg;
    }

    public int getType() {
        return type;
    }

    public Msg(String msg, int type) {
        this.msg = msg;
        this.type = type;
    }
}
