package com.zzh.listview.model;

/**
 * Created by zzh on 2016/3/3.
 */
public class Person {
    private String uid;
    private String userName;
    private String imageHeadUrl;



    public Person() {
    }

    public Person(String uid, String userName, String imageHeadUrl) {
        this.uid = uid;
        this.userName = userName;
        this.imageHeadUrl = imageHeadUrl;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getImageHeadUrl() {
        return imageHeadUrl;
    }

    public void setImageHeadUrl(String imageHeadUrl) {
        this.imageHeadUrl = imageHeadUrl;
    }
}
