package com.example.trungnguyen.labuit.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import com.example.trungnguyen.labuit.R
import com.example.trungnguyen.labuit.helper.ContactDbHelper

class LabSQLiteActivity : AppCompatActivity(), View.OnClickListener, AdapterView.OnItemLongClickListener {


    private lateinit var mDbHelper: ContactDbHelper
    private var mContactList: ArrayList<String> = ArrayList()
    private lateinit var mContactAdapter: ArrayAdapter<String>

    override fun onItemLongClick(p0: AdapterView<*>?, p1: View?, position: Int, p3: Long): Boolean {
        if (position < 0) return false
        mDbHelper.deleteById(mDbHelper.getAllContact()[position].getId())
        updateContactList()
        return false
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.btUpdate -> {
                mDbHelper.updateContactByName("An", "1111")
                updateContactList()
            }
            R.id.btDeleteAll -> {
                mDbHelper.deleteAllContact()
                updateContactList()
            }
            else -> return
        }
    }

    private fun updateContactList() {
        if (mContactList.size > 0)
            mContactList.clear()
        mContactList.addAll(getListContact())
        mContactAdapter.notifyDataSetChanged()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lab_sqlite)
        mDbHelper = ContactDbHelper(this)
        addContacts()
        mContactList = getListContact()
        mContactAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, mContactList)
        initViews()
        getListContact()
    }

    private fun initViews() {
        val lvContact = findViewById<ListView>(R.id.lvContact)
        lvContact.onItemLongClickListener = this
        lvContact.adapter = mContactAdapter
        findViewById<Button>(R.id.btUpdate).setOnClickListener(this)
        findViewById<Button>(R.id.btDeleteAll).setOnClickListener(this)
    }

    private fun getListContact(): ArrayList<String> {
        val contactInString = ArrayList<String>()
        val tempList = mDbHelper.getAllContact()
        if (tempList.size > 0)
            tempList.forEach { contactInString.add(it.toString()) }
        return contactInString
    }

    private fun addContacts() {
        mDbHelper.deleteAllContact()
        mDbHelper.addNewContact("An", "9100000000")
        mDbHelper.addNewContact("Binh", "9199999999")
        mDbHelper.addNewContact("Chau", "9522222222")
        mDbHelper.addNewContact("Danh", "9533333333")
        mDbHelper.addNewContact("Ten Nam", "131415")
        mDbHelper.addNewContact("Ten Sau", "161718")
        mDbHelper.addNewContact("Ten Bay", "192021")
    }

    override fun onResume() {
        super.onResume()
        if (mDbHelper != null) mDbHelper.openDb()
    }

    override fun onStop() {
        super.onStop()
        if (mDbHelper != null) mDbHelper.closeDb()
    }
}
