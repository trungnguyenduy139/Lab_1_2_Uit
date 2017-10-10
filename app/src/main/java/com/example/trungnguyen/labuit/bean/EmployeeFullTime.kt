package com.example.trungnguyen.labuit.bean

/**
 * Author : Trung Nguyen
 * Date : 9/28/2017
 */

class EmployeeFullTime(mId: String, mName: String) : Employee(mId, mName) {

    private var mIsManager = false

    fun isManager() = mIsManager

    constructor(id: String, name: String, isManager: Boolean) : this(id, name) {
        mIsManager = isManager
    }

    override fun employeeType(): String {
        return "Full Time"
    }

    override fun salary(): String {
        return " 500.0"
    }
}
