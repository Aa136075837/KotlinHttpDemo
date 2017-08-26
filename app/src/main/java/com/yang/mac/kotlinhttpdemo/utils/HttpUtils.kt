package com.yang.mac.kotlinhttpdemo.utils

import com.ohmerhe.kolley.request.Http

/**
 * Created by bo on 2017/8/26.
 */
object HttpUtils {
    fun getRequest(requestUrl: String, map: Map<String, String>, listener: RequestListener, what: Int) {
        Http.get {
            url = requestUrl
            headers {
                "Accept" - "application/json"
                "Content-Type" - "application/json"
            }

            tag = what

            map.forEach {
                params {
                    it.key - it.value
                }
            }

            onSuccess { bytes ->
                listener.success(what, bytes)
            }

            onFail { error ->
                listener.failed(what, error)
            }
        }
    }


    fun postRequest(requestUrl: String, map: Map<String, String>, listener: RequestListener, what: Int) {
        Http.post {
            url = requestUrl
            headers {
                "Accept" - "application/json"
                "Content-Type" - "application/json"
            }
            tag = what

            map.forEach {
                params {
                    it.key - it.value
                }
            }
            onSuccess { bytes ->
                listener.success(what, bytes)
            }

            onFail { error ->
                listener.failed(what, error)
            }
        }
    }
}
