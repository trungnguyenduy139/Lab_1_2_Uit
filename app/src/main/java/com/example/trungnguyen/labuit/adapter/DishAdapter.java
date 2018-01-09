package com.example.trungnguyen.labuit.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.trungnguyen.labuit.R;
import com.example.trungnguyen.labuit.bean.Dish;

import java.util.ArrayList;


/**
 * Author : Trung Nguyen
 * Date : 10/6/2017
 */

public class DishAdapter extends BaseAdapter {

    private Context mContext;
    private ArrayList<Dish> mDataList;

    public DishAdapter(Context context, ArrayList<Dish> list) {
        mContext = context;
        mDataList = list;
    }

    @Override
    public int getCount() {
        return mDataList.size();
    }

    @Override
    public Object getItem(int position) {
        return mDataList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(mContext).inflate(R.layout.dish_item, viewGroup, false);
            view.setLayoutParams(new GridView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        }
        ImageView imgFood = view.findViewById(R.id.imgFood);
        ImageView imgPromotion = view.findViewById(R.id.imgPromotion);
        if (imgPromotion.getVisibility() == View.VISIBLE)
            imgPromotion.setVisibility(View.GONE);
        TextView txtFoodName = view.findViewById(R.id.txtDish);
        Dish dish = mDataList.get(position);
        if (dish.getIsPromotion()) {
            if (imgPromotion.getVisibility() == View.GONE)
                imgPromotion.setVisibility(View.VISIBLE);
        }
        imgFood.setImageResource(dish.getResId());
        txtFoodName.setText(dish.getDisName());
        return view;
    }
}
