package com.yang.mac.kotlinhttpdemo.utils

import java.net.URL

/**
 * Created by bo on 2017/8/24.
 */
open class RegisterRequest(val url:String){

    fun params(){

    }
    fun run() {
        val forecastJsonStr = URL(url).readText()
    }
}