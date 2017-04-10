package com.fudd.retrofitdemo.model;

import com.google.gson.annotations.Expose;

/**
 * Created by fudiandong on 2017/4/10.
 */

public class User {
    @Expose
    private String name;
    @Expose
    private String blog;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBlog() {
        return blog;
    }

    public void setBlog(String blog) {
        this.blog = blog;
    }
}
