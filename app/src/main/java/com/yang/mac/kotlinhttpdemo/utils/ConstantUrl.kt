package com.yang.mac.kotlinhttpdemo.utils

/**
 * Created by bo on 2017/8/24.
 */
public class ConstantUrl {
    companion object {
        val BASE_URL = "http://static8dmap.chinacloudapp.cn:8080/app/cuser/"
        val REGISTER_URL = BASE_URL + "regist"
        val SEND_REGISTER_CODE =BASE_URL + "sendRegistCode"
        val CHECK_CODE = BASE_URL + "checkCode"
    }

}