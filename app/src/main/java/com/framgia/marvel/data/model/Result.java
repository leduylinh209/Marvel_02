package com.framgia.marvel.data.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by asus on 5/12/2017.
 */

public class Result {
    @SerializedName("id")
    private int mId;
    @SerializedName("name")
    private String mName;
    @SerializedName("description")
    private String mDescription;
    @SerializedName("thumnail")
    private Thumnail mThumnail;

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        mDescription = description;
    }

    public Thumnail getThumnail() {
        return mThumnail;
    }

    public void setThumnail(Thumnail thumnail) {
        mThumnail = thumnail;
    }
}
