package com.example.trungnguyen.labuit.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.example.trungnguyen.labuit.R
import com.example.trungnguyen.labuit.adapter.EmployeeAdapter
import com.example.trungnguyen.labuit.bean.Employee
import com.example.trungnguyen.labuit.bean.EmployeeFullTime

class ListViewTh5Activity : AppCompatActivity(), View.OnClickListener {

    private var mAdapter: EmployeeAdapter? = null
    private var cbIsManager: CheckBox? = null
    private var etEmployeeId: EditText? = null
    private var etEmployeeName: EditText? = null
    private var btAddMoreEmployee: Button? = null
    private var mListView5: ListView? = null
    private val mEmployeeList: ArrayList<EmployeeFullTime> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listview_th5)
        initViews()
        mAdapter = EmployeeAdapter(this, R.layout.item_employee, mEmployeeList)
        mListView5?.adapter = mAdapter
    }

    private fun initViews() {
        mListView5 = findViewById(R.id.lvTh5)
        cbIsManager = findViewById(R.id.cb_is_manager)
        etEmployeeId = findViewById(R.id.etEmployeeId)
        etEmployeeName = findViewById(R.id.etEmployeeName)
        btAddMoreEmployee = findViewById(R.id.btAddMoreEmployee)
        btAddMoreEmployee?.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        addNewEmployee()
    }

    private fun addNewEmployee() {
        val name = etEmployeeName?.text.toString()
        val id = etEmployeeId?.text.toString()
        val position = cbIsManager?.isChecked
        if (name.isEmpty() || id.isEmpty()) {
            Toast.makeText(this, "Vui Lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show()
            return
        }
        mEmployeeList.add(EmployeeFullTime(id, name, position!!))
        mAdapter?.notifyDataSetChanged()
        etEmployeeId?.setText("")
        etEmployeeName?.setText("")
        cbIsManager?.isChecked = false
        etEmployeeId?.requestFocus()
    }
}
