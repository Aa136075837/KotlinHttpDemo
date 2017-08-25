package com.yang.mac.kotlinhttpdemo.ui

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.widget.Toast
import com.yang.mac.kotlinhttpdemo.R
import com.yang.mac.kotlinhttpdemo.utils.ConstantUrl
import com.yang.mac.kotlinhttpdemo.utils.RegisterRequest
import kotlinx.android.synthetic.main.activity_register.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        initListener()
    }

    private fun initListener() {
        act_register_get_code.setOnClickListener {
            //            RegisterRequest(ConstantUrl.SEND_REGISTER_CODE).run()
        }

        act_register_next.setOnClickListener {
            doAsync {
                RegisterRequest("http://static8dmap.chinacloudapp.cn:8080/app/cuser/checkCode?subject=%2B8617324450759&code=7982").run()
            }

            MacApplication.mHandler.postDelayed(Runnable {
                kotlin.run {
                    val intent: Intent = Intent(RegisterActivity@ this, LoginActivity::class.java)
                    startActivity(intent)
                }
            }, 3000)
        }
    }


}
