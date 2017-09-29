package com.example.trungnguyen.labuit

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.example.trungnguyen.labuit.activity.LinearLayoutCodeActivity
import com.example.trungnguyen.labuit.activity.LinearLayoutXmlActivity
import com.example.trungnguyen.labuit.activity.ListView4Activity
import com.example.trungnguyen.labuit.activity.RelativeLayoutActivity

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private var btLinearCode: Button? = null
    private var btLinearXml: Button? = null
    private var btRelative: Button? = null
    private var btListViewTH4: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
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
            R.id.btRelativeLayout -> intent = Intent(this, RelativeLayoutActivity::class.java)

            R.id.btLinearLayout_Xml -> intent = Intent(this, LinearLayoutXmlActivity::class.java)

            R.id.btLinearLayout_Code -> intent = Intent(this, LinearLayoutCodeActivity::class.java)

            R.id.lvTh4 -> intent = Intent(this, ListView4Activity::class.java)
        }
        startActivity(intent)
    }
}
