package com.example.trungnguyen.labuit.activity

import android.annotation.SuppressLint
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import com.example.trungnguyen.labuit.R


class LinearLayoutCodeActivity : AppCompatActivity() {

    private var llNameContainer: LinearLayout? = null
    private var llAddressContainer: LinearLayout? = null
    private var llParentContainer: LinearLayout? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_linear_layout_code)
        createNameContainer()
        createAddressContainer()
        createParentContainer()
        setContentView(llParentContainer)
    }

    private fun createNameContainer() {
        llNameContainer = LinearLayout(this)
        llNameContainer?.layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT)
        llNameContainer?.orientation = LinearLayout.HORIZONTAL

        val tvName = TextView(this)
        tvName.text = "Name: "
        llNameContainer?.addView(tvName)

        val tvNameValue = TextView(this)
        tvNameValue.text = "John Doe"
        llNameContainer?.addView(tvNameValue)

    }

    private fun createParentContainer() {
        llParentContainer = LinearLayout(this)

        llParentContainer?.layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT)
        llParentContainer?.orientation = LinearLayout.VERTICAL

        llParentContainer?.addView(llNameContainer)
        llParentContainer?.addView(llAddressContainer)

    }

    @SuppressLint("SetTextI18n")
    private fun createAddressContainer() {
        llAddressContainer = LinearLayout(this)
        llAddressContainer?.layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT)
        llAddressContainer?.orientation = LinearLayout.HORIZONTAL

        val tvAddress = TextView(this)
        tvAddress.text = "Address:"
        llAddressContainer?.addView(tvAddress)

        val tvAddressValue = TextView(this)
        tvAddressValue.text = "911 Hollywood Blvd";
        llAddressContainer?.addView(tvAddressValue);

    }
}
