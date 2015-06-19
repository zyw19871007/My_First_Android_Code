package com.shadow.zyw.sdu.chapter13;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * Created by shadow on 2015/6/19.
 */
public class PersonParcel implements Parcelable {
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(age);


    }
    public static final Parcelable.Creator<PersonParcel> CREATOR = new Creator<PersonParcel>() {
        @Override
        public PersonParcel createFromParcel(Parcel source) {
            PersonParcel personParcel = new PersonParcel();
            personParcel.name = source.readString();
            personParcel.age = source.readInt();
            return personParcel;
        }

        @Override
        public PersonParcel[] newArray(int size) {
            return new PersonParcel[size];
        }
    };
}
