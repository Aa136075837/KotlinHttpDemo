package com.yang.mac.kotlinhttpdemo.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.TextInputEditText
import com.yang.mac.kotlinhttpdemo.R

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        initViews()
    }

    private fun initViews() {
        val editUserName = findViewById<TextInputEditText>(R.id.user_name)
        val editPassWord = findViewById<TextInputEditText>(R.id.pass_word)
    }
}
