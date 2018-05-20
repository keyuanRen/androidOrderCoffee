package com.example.kyousukeg.myapplication;

public class model_shopList {
    String title;
    String desc;
    int icon;

    //constructor

    public model_shopList(String title, String desc, int icon) {
        this.title = title;
        this.desc = desc;
        this.icon = icon;
    }

    //getter

    public String getTitle() {
        return this.title;
    }

    public String getDesc() {
        return this.desc;
    }

    public int getIcon() {
        return this.icon;
    }
}
