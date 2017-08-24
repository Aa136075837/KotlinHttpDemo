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

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        initListener()
    }

    private fun initListener() {
        act_register_get_code.setOnClickListener {
            RegisterRequest(ConstantUrl.SEND_REGISTER_CODE).run()
        }

        act0_register_next.setOnClickListener {
            RegisterRequest(ConstantUrl.CHECK_CODE).run()
            MacApplication.mHandler.postDelayed(Runnable {
                kotlin.run {
                    val intent:Intent = Intent(RegisterActivity,LoginActivity)
                    startActivities()
                }
            },3000)
        }
    }

}
