package com.example.jx.test2

import android.content.Context
import com.example.jx.tools.LogUtil

class Test2 {
    private val TAG = "Test2"
    fun startTest(context: Context) {
        LogUtil.logd(TAG, "start test")
        //testIf(3)
        //testWhen(9)
        //testFor()
        testLabel()
    }

    private fun testIf(a: Int) {
        LogUtil.logd(TAG, "testIf")
        val b = if (a > 5) a else 5
        LogUtil.logd(TAG, "b=$b")
        val c = if (a > 6) {
            LogUtil.logd(TAG, "a>6")
            a
        } else {
            LogUtil.logd(TAG, "a<=6")
            6       //赋值要写在最后一行，才可以赋值给c
        }
        LogUtil.logd(TAG, "c=$c")
        if (a in 1..8) {
            LogUtil.logd(TAG, "a在1,8区间")
        }
    }

    //相当于java的switch
    private fun testWhen(a: Int) =
        when (a) {
            1 -> LogUtil.logd(TAG, "1")
            2 -> LogUtil.logd(TAG, "2")
            3, 4 -> LogUtil.logd(TAG, "3 or 4")
            in 5..6 -> LogUtil.logd(TAG, "5~6")
            !in 7..8 -> LogUtil.logd(TAG, "不在7~8")
            else -> {
                LogUtil.logd(TAG, "$a")
            }
        }

    fun testFor() {
        LogUtil.logd(TAG, "testFor")
        val a = listOf(1, 2, 3)
        for (i in a) {
            LogUtil.logd(TAG, "$i")
        }
        for (i in a.indices) {
            LogUtil.logd(TAG, "${a[i]}")
        }
    }

    //标签搭配continue,break,return使用
    fun testLabel() {
        LogUtil.logd(TAG, "testLabel")
        val a = intArrayOf(1, 2, 3, 4, 5)
        a.forEach here@{
            if (it == 3) return@here
            LogUtil.logd(TAG, "$it")
        }
        start@ for (i in a) {
            for (j in a) {
                if (3 == j) {
                    continue@start
                }
                LogUtil.logd(TAG, "i = $i,j = $j")
            }
        }

        start1@ for (i in a) {
            for (j in a) {
                if (3 == j) {
                    break@start1
                }
                LogUtil.logd(TAG, "i = $i,j = $j")
            }
        }
    }
}