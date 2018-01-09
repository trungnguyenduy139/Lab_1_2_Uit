package com.example.trungnguyen.labuit.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.example.trungnguyen.labuit.R
import com.example.trungnguyen.labuit.bean.EmployeeFullTime
import com.example.trungnguyen.labuit.bean.EmployeePartTime
import com.example.trungnguyen.labuit.helper.ConstantHelper
import com.example.trungnguyen.labuit.helper.UtilHelper

class ListView4Activity : AppCompatActivity(), View.OnClickListener, AdapterView.OnItemLongClickListener {

    override fun onItemLongClick(p0: AdapterView<*>?, view: View?, position: Int, p3: Long): Boolean {
        mEmployeeList.removeAt(position)
        mAdapter?.notifyDataSetChanged()
        return true
    }

    override fun onClick(view: View) {
        addNewEmployee()
    }

    private var mAdapter: ArrayAdapter<String>? = null
    private var rgEmployeeType: RadioGroup? = null
    private var etEmployeeId: EditText? = null
    private var etEmployeeName: EditText? = null
    private var btAddMoreEmployee: Button? = null
    private var mListView4: ListView? = null
    private val mEmployeeList: ArrayList<String> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view4)
        initViews()
        setupListView()
    }

    private fun setupListView() {
        mAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, mEmployeeList)
        mListView4?.adapter = mAdapter
    }

    private fun initViews() {
        mListView4 = findViewById(R.id.lv4)
        mListView4?.onItemLongClickListener = this
        rgEmployeeType = findViewById(R.id.rgEmployeeType)
        etEmployeeId = findViewById(R.id.etEmployeeId)
        etEmployeeName = findViewById(R.id.etEmployeeName)
        btAddMoreEmployee = findViewById(R.id.btAddMoreEmployee)
        btAddMoreEmployee?.setOnClickListener(this)
    }

    private fun addNewEmployee() {
        val employeeType = rgEmployeeType?.checkedRadioButtonId
        val name = etEmployeeName?.text.toString()
        val id = etEmployeeId?.text.toString()
        if (name.isEmpty() || id.isEmpty() || employeeType == -1) {
            UtilHelper.showMsg(this, "Vui lòng nhập đầy đủ thông tin")
            return
        }
        val newEmployee = if (employeeType == R.id.rbEmployeeFullTime) {
            EmployeeFullTime(id, name)
        } else EmployeePartTime(id, name)
        mEmployeeList.add(newEmployee.toString())
        mAdapter?.notifyDataSetChanged()
        etEmployeeName?.setText("")
        etEmployeeId?.setText("")
        rgEmployeeType?.clearCheck()
        etEmployeeId?.requestFocus()
    }

}
