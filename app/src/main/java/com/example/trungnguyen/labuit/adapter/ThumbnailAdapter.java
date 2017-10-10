package com.example.trungnguyen.labuit.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.trungnguyen.labuit.R;
import com.example.trungnguyen.labuit.bean.Thumbnail;

/**
 * Author : Trung Nguyen
 * Date : 10/6/2017
 */

public class ThumbnailAdapter extends ArrayAdapter<Thumbnail> {

    private Context mContext;
    private Thumbnail[] mThumbnailList;

    public ThumbnailAdapter(@NonNull Context context, int resource, @NonNull Thumbnail[] objects) {
        super(context, resource, objects);
        mContext = context;
        mThumbnailList = objects;
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }

    private View getCustomView(int position, View view, ViewGroup parent) {
        if (view == null) {
            view = LayoutInflater.from(mContext).inflate(R.layout.item_thubnail, parent, false);
        }
        Thumbnail thumbnail = mThumbnailList[position];
        TextView txtThumbnailName = view.findViewById(R.id.txtThumbnailName);
        ImageView imgThumbnail = view.findViewById(R.id.imgThumbnail);
        txtThumbnailName.setText(thumbnail.getName());
        imgThumbnail.setImageResource(thumbnail.getResId());
        return view;
    }
}
