package com.example.trungnguyen.labuit.bean

/**
 * Author : Trung Nguyen
 * Date : 9/28/2017
 */

class EmployeeFullTime(mId: String, mName: String) : Employee(mId, mName) {

    override fun employeeType(): String {
        return "Full Time"
    }

    override fun salary(): String {
        return " 500.0"
    }
}
