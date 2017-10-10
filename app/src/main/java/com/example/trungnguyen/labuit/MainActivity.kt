package com.example.trungnguyen.labuit

import android.content.Intent
import android.content.pm.PackageManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.example.trungnguyen.labuit.activity.*
import com.example.trungnguyen.labuit.view.ContactDialog
import android.R.attr.phoneNumber
import com.example.trungnguyen.labuit.helper.ConstantHelper


class MainActivity : AppCompatActivity(), View.OnClickListener {

    private var btLinearCode: Button? = null
    private var btLinearXml: Button? = null
    private var btRelative: Button? = null
    private var btListViewTH4: Button? = null
    private lateinit var mContactDialog: ContactDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
        mContactDialog = ContactDialog(this)
    }

    private fun initViews() {
        btLinearCode = findViewById(R.id.btLinearLayout_Code)
        btLinearCode?.setOnClickListener(this)
        btLinearXml = findViewById(R.id.btLinearLayout_Xml)
        btLinearXml?.setOnClickListener(this)
        btRelative = findViewById(R.id.btRelativeLayout)
        btRelative?.setOnClickListener(this)
        btListViewTH4 = findViewById(R.id.lvTh4)
        btListViewTH4?.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        var intent: Intent? = null
        when (view.id) {
            R.id.btRelativeLayout -> intent = Intent(this, ListViewTh5Activity::class.java)

            R.id.btLinearLayout_Xml -> intent = Intent(this, GridViewActivity::class.java)

            R.id.btLinearLayout_Code -> intent = Intent(this, ListView4Activity::class.java)

            R.id.lvTh4 -> {
//                intent = Intent(this, ListViewTh3Activity::class.java)
                showContactDialog()
                return
            }
        }
        startActivity(intent)
    }


    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        when (requestCode) {
            ConstantHelper.REQUEST_PHONE_CALL_PERMISSION_CODE -> {
                if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)
                    mContactDialog.requestPhoneCallPermission(phoneNumber.toString())
            }
        }
    }

    private fun showContactDialog() {
        mContactDialog.show()
    }
}
