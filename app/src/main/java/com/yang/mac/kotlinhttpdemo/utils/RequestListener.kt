package com.yang.mac.kotlinhttpdemo.utils

import com.android.volley.VolleyError

/**
 * Created by bo on 2017/8/26.
 */
interface RequestListener {
    fun success(tag: Int, bytes: ByteArray)

    fun failed(tag: Int, error: VolleyError)
}