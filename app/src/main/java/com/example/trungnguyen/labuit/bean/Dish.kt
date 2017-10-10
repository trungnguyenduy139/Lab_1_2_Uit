package com.example.trungnguyen.labuit.bean

/**
 * Author : Trung Nguyen
 * Date : 10/9/2017
 */
class Dish(resId: Int, name: String, isPromotion: Boolean) {

    private var mResId = 0
    private var mName = ""
    private var mPromotion = false

    init {
        mResId = resId
        mName = name
        mPromotion = isPromotion
    }

    fun getResId() = mResId
    fun getDisName() = mName
    fun getIsPromotion() = mPromotion
}