package com.example.trungnguyen.labuit.view

import android.Manifest
import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.Window
import android.widget.ImageView
import android.widget.TextView
import com.example.trungnguyen.labuit.R
import com.example.trungnguyen.labuit.helper.ConstantHelper
import android.content.Intent
import android.support.v4.app.ActivityCompat
import android.content.pm.PackageManager
import android.net.Uri
import com.example.trungnguyen.labuit.MainActivity
import android.support.v4.content.ContextCompat
import android.widget.LinearLayout


/**
 * Author : Trung Nguyen
 * Date : 10/10/2017
 */
class ContactDialog(context: Context) : AlertDialog(context), View.OnClickListener {
    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.btn_close -> this.dismiss()
            R.id.btn_call -> funcCall()
            R.id.btn_send -> funcSendEmail()
        }
    }

    private val mName = "Trung Nguyen Duy"
    private val mEmailAddress = "trungnguyenduy139@gmail.com"
    private val mPhone = "0939102601"
    private val mContext: Context = context

    override fun onCreate(savedInstanceState: Bundle?) {
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.custom_dialog)
        initViews()
    }

    private fun funcSendEmail() {
        val emailIntent = Intent(android.content.Intent.ACTION_SEND)
        emailIntent.type = "text/plain"
        emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, arrayOf(mEmailAddress))
        emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Hello Mobile Development Class")
        emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, "Here is a simple text")
        emailIntent.type = "message/rfc822"
        try {
            mContext.startActivity(Intent.createChooser(emailIntent, "Send email using..."))
        } catch (err: android.content.ActivityNotFoundException) {
            ConstantHelper.showToast(mContext, "No email clients installed.")
        }
    }

    private fun funcCall() {
        requestPhoneCallPermission(mPhone)
    }

    fun requestPhoneCallPermission(phoneNum: String) {
        if (ContextCompat.checkSelfPermission(mContext, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(mContext as MainActivity,
                    arrayOf(Manifest.permission.CALL_PHONE), ConstantHelper.REQUEST_PHONE_CALL_PERMISSION_CODE)
        } else {
            val call = Uri.parse("tel:" + phoneNum)
            val intentPhoneCall = Intent(Intent.ACTION_CALL, call)
            mContext.startActivity(intentPhoneCall)
        }
    }

    @SuppressLint("SetTextI18n")
    private fun initViews() {
        val btnClose = findViewById<ImageView>(R.id.btn_close)
        btnClose.setOnClickListener(this)
        val btnCall = findViewById<LinearLayout>(R.id.btn_call)
        btnCall.setOnClickListener(this)
        val btnSend = findViewById<LinearLayout>(R.id.btn_send)
        btnSend.setOnClickListener(this)
        val txtName = findViewById<TextView>(R.id.txt_name)
        val txtEmailAddress = findViewById<TextView>(R.id.txt_mail_address)
        val txtPhoneNumber = findViewById<TextView>(R.id.txt_phone)
        txtName?.text = ConstantHelper.DIALOG_NAME_PREFIX + mName
        txtEmailAddress?.text = ConstantHelper.DIALOG_ADDRESS_PREFIX + mEmailAddress
        txtPhoneNumber?.text = ConstantHelper.DIALOG_PHONE_PREFIX + mPhone
    }
}