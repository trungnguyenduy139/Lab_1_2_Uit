package com.example.trungnguyen.labuit.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import com.example.trungnguyen.labuit.R
//ListView TH2
class ListViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view)
        val lvTest = findViewById<ListView>(R.id.lvTest)
        val array = resources.getStringArray(R.array.array_name)
        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, array)
        lvTest.adapter = adapter
    }
}
