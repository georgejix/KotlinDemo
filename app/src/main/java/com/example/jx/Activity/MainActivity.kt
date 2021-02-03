package com.example.jx.Activity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import com.example.jx.R
import com.example.jx.Test
import com.example.jx.Test2
import com.example.jx.Test3
import com.example.jx.tools.LogUtil


class MainActivity : Activity() {
    private val TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (intent.flags and Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT != 0) {
            LogUtil.logd(TAG, "BROUGHT_TO_FRONT")
            finish()
            return
        } else {
            LogUtil.logd(TAG, "NOT BROUGHT_TO_FRONT")
        }
        setContentView(R.layout.activity_main)
        Test().startTest(this)
        Test2().startTest(this)
        Test3("ppp", "ppp2").startTest(this)
    }
}
