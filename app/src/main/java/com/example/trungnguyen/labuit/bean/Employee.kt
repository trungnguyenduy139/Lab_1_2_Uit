package com.example.trungnguyen.labuit.bean

/**
 * Author : Trung Nguyen
 * Date : 9/28/2017
 */

abstract class Employee(id: String, name: String) {

    private var mId = ""
    private var mName = ""

    init {
        mId = id
        mName = name
    }

    fun convertToString(): String {
        return mId + " - " + mName + " ---> " + employeeType() + salary()
    }

    abstract fun employeeType(): String


    abstract fun salary(): String
}
