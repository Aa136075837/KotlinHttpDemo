package com.yang.mac.kotlinhttpdemo.utils

import android.util.Log
import java.net.URL

/**
 * Created by bo on 2017/8/24.
 */
open class RegisterRequest(val url:String){
    val TAG:String = "RegisterRequest"

    fun params(){

    }

    fun run() {
        val forecastJsonStr = URL(url).readText()
        Log.e(TAG,"  forecastJsonStr  = "  +forecastJsonStr)
    }
}