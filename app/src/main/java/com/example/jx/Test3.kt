package com.example.jx

import android.content.Context
import com.example.jx.tools.LogUtil

//测试kotlin类和对象
class Test3 constructor(val params: String) {
    private val TAG = "Test3"
    private var mParams = params

    init {
        LogUtil.logd(TAG, "params=${mParams}")
    }

    constructor(params1: String, params2: String) : this(params2) {
        LogUtil.logd(TAG, "constructor")
    }

    var name: String = "zhangsan"
        get() = field.toUpperCase()

    var age: Int = 18
        get() = field
        set(value) {
            if (value > 18)
                field = 18
            else
                field = value
        }

    fun startTest(context: Context) {
        testField()
    }

    fun testField() {
        LogUtil.logd(TAG, "testField")
        LogUtil.logd(TAG, "$name")
        age = 22
        LogUtil.logd(TAG, "$age")

    }

    fun Test2.addFun() {
        LogUtil.logd(TAG, "addFun")
    }

    val Test3.TAG33: String
        get() = "Test33"
}