package com.example.trungnguyen.labuit.helper

import android.content.Context
import android.widget.Toast

/**
 * Author : Trung Nguyen
 * Date : 10/13/2017
 */
object UtilHelper {
    fun showMsg(context: Context, msg: String) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }
}