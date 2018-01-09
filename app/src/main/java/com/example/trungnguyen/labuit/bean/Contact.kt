package com.example.trungnguyen.labuit.bean

/**
 * Author : Trung Nguyen
 * Date : 10/16/2017
 */
class Contact(id: Int, name: String, phoneNum: String) {
    private var mId = 0
    private var mName = ""
    private var mPhoneNumber = ""

    init {
        mId = id
        mName = name
        mPhoneNumber = phoneNum
    }

    override fun toString(): String {
        return "ID: $mId -- Name: $mName -- Phone Number: $mPhoneNumber"
    }

    fun getId() = mId
    fun getContactName() = mName
    fun getPhoneNumber() = mPhoneNumber
}