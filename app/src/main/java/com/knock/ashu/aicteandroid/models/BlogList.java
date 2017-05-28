package com.knock.ashu.aicteandroid.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Ashu on 1/3/2017.
 */

public class BlogList {

    @SerializedName("data")
    @Expose
    private List<Blog> data = null;

    public List<Blog> getData() {
        return data;
    }

    public void setData(List<Blog> data) {
        this.data = data;
    }
}
