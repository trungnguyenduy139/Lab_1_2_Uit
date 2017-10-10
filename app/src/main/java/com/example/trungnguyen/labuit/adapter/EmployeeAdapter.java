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
import com.example.trungnguyen.labuit.bean.EmployeeFullTime;
import java.util.List;

/**
 * Author : Trung Nguyen
 * Date : 10/6/2017
 */

public class EmployeeAdapter extends ArrayAdapter<EmployeeFullTime> {

    private List<EmployeeFullTime> mEmployeeList;
    private Context mContext;

    public EmployeeAdapter(@NonNull Context context, int resource, @NonNull List<EmployeeFullTime> objects) {
        super(context, resource, objects);
        mContext = context;
        mEmployeeList = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_employee, parent, false);
        }
        EmployeeFullTime employee = mEmployeeList.get(position);
        TextView txtFullName = convertView.findViewById(R.id.item_employee_tv_fullname);
        TextView txtPosition = convertView.findViewById(R.id.item_employee_tv_position);
        ImageView imgManager = convertView.findViewById(R.id.item_employee_iv_manager);
        txtFullName.setText(employee.getName());
        if (employee.isManager()) {
            imgManager.setVisibility(View.VISIBLE);
            txtPosition.setVisibility(View.GONE);
        } else {
            txtPosition.setVisibility(View.VISIBLE);
            txtPosition.setText(mContext.getString(R.string.staff));
            imgManager.setVisibility(View.GONE);
        }
        if (position % 2 == 0)
            convertView.setBackgroundResource(R.color.white);
        else convertView.setBackgroundResource(R.color.light_blue);

        return convertView;
    }
}
