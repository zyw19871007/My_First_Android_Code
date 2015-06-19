package com.shadow.zyw.sdu.chapter13;

import android.content.Intent;

import java.io.Serializable;

/**
 * Created by shadow on 2015/6/19.
 */
public class Person implements Serializable {
    private String name;
    private int age;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
