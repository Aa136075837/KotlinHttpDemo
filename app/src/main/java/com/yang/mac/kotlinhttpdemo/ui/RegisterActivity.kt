package com.yang.mac.kotlinhttpdemo.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.android.volley.VolleyError
import com.yang.mac.kotlinhttpdemo.R
import com.yang.mac.kotlinhttpdemo.utils.ConstantUrl
import com.yang.mac.kotlinhttpdemo.utils.RequestListener
import com.yang.mac.kotlinhttpdemo.utils.HttpUtils
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {
    val TAG: String = "RegisterActivity"

    companion object {
        val REGISTER_WHAT: Int = 0x123
        val SEND_CODE_WHAT: Int = 0x124
        val CHECK_CODE_WHAT: Int = 0x125

        fun showTaost(msg: String) {
            Toast.makeText(MacApplication.mContext, msg, Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        initListener()
    }

    private object mListener : RequestListener {

        override fun success(tag: Int, bytes: ByteArray) {
            when (tag) {
                REGISTER_WHAT  -> showTaost("注册成功" + String(bytes))
                SEND_CODE_WHAT -> showTaost("验证码已发送"+ String(bytes))
            }
        }

        override fun failed(tag: Int, error: VolleyError) {
            showTaost("请求失败！！" + error.message)
        }
    }

    private fun initListener() {
        act_register_get_code.setOnClickListener {
            val map: Map<String, String> = mapOf(
                    "subject" to act_register_username.text.toString(),
                    "lang_code" to "zh_cn",
                    "brandMaker" to "00000")
            HttpUtils.getRequest(ConstantUrl.SEND_REGISTER_CODE, map, mListener, SEND_CODE_WHAT)
        }

        act_register_next.setOnClickListener {
            val map: Map<String, String> = mapOf(
                    "subject" to act_register_username.text.toString(),
                    "code" to act_register_code.text.toString(),
                    "pwd" to "aaaaaaaa",
                    "repwd" to "aaaaaaaa")
            HttpUtils.postRequest(ConstantUrl.REGISTER_URL, map, mListener, REGISTER_WHAT)
        }
    }
}
