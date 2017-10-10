package com.example.trungnguyen.labuit.helper

import android.content.Context
import android.widget.Toast

/**
 * Author : Trung Nguyen
 * Date : 10/10/2017
 */
object ConstantHelper {
    const val SUB_STRING_INDEX = 15
    const val DIALOG_NAME_PREFIX = "Name: "
    const val DIALOG_ADDRESS_PREFIX = "Email: "
    const val DIALOG_PHONE_PREFIX = "Phone: "
    const val REQUEST_PHONE_CALL_PERMISSION_CODE = 1111

    fun showToast(context: Context, msg: String) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
    }
}