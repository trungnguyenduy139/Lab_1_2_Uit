package com.example.trungnguyen.labuit.activity

import android.annotation.SuppressLint
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.example.trungnguyen.labuit.R

class ListViewTh3Activity : AppCompatActivity(), View.OnClickListener, AdapterView.OnItemClickListener {
    @SuppressLint("SetTextI18n")
    override fun onItemClick(p0: AdapterView<*>?, p1: View?, position: Int, p3: Long) {
        txtPos?.text = "position : " + position + "; value : " + mNames[position]
        p1?.setBackgroundColor(Color.BLUE)
    }

    override fun onClick(p0: View?) {
        val enterName = etTen?.text.toString()
        mNames.add(enterName)
        mAdapter?.notifyDataSetChanged()
        etTen?.setText("")
        etTen?.requestFocus()
    }

    private var lvTH3: ListView? = null
    private var txtPos: TextView? = null
    private var btNhap: Button? = null
    private var etTen: EditText? = null
    private val mNames: ArrayList<String> = ArrayList()
    private var mAdapter: ArrayAdapter<String>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view_th3)
        initViews()
        setupListVew()
    }

    private fun setupListVew() {
        mAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, mNames)
        lvTH3?.adapter = mAdapter
    }

    private fun initViews() {
        lvTH3 = findViewById(R.id.lvTh3)
        lvTH3?.onItemClickListener = this
        txtPos = findViewById(R.id.txtValuePos)
        btNhap = findViewById(R.id.btNhap)
        btNhap?.setOnClickListener(this)
        etTen = findViewById(R.id.etTen)
    }
}
