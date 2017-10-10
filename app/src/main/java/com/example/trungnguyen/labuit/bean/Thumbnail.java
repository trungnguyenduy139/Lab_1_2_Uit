package com.example.trungnguyen.labuit.bean;

import com.example.trungnguyen.labuit.R;

/**
 * Author : Trung Nguyen
 * Date : 10/6/2017
 */

public enum Thumbnail {

    THUMBNAIL_1("Thumbnail 1", R.drawable.first_thumbnail),
    THUMBNAIL_2("Thumbnail 2", R.drawable.second_thumbnail),
    THUMBNAIL_3("Thumbnail 3", R.drawable.third_thumbnail),
    THUMBNAIL_4("Thumbnail 4", R.drawable.fourth_thumbnail);

    private String mName;
    private int mResId;

    Thumbnail(String name, int id) {
        mName = name;
        mResId = id;
    }

    public String getName() {
        return mName;
    }

    public int getResId() {
        return mResId;
    }
}
