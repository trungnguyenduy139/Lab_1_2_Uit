package com.example.trungnguyen.labuit.bean

/**
 * Author : Trung Nguyen
 * Date : 9/28/2017
 */

class EmployeePartTime(mId: String, mName: String) : Employee(mId, mName) {

    override fun employeeType(): String {
        return " Part Time"
    }

    override fun salary(): String {
        return " 150.0"
    }
}
