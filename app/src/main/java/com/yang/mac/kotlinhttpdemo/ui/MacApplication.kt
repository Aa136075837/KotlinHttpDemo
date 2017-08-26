package com.yang.mac.kotlinhttpdemo.ui

import android.app.Application
import android.content.Context
import android.os.Handler
import com.ohmerhe.kolley.request.Http

/**
 * Created by bo on 2017/8/24.
 */
class MacApplication : Application() {
    companion object {
        lateinit var mContext: Context

        lateinit var mHandler: Handler
    }

    override fun onCreate() {
        super.onCreate()
        mContext = this
        mHandler = Handler()
        Http.init(this)
    }
}