package com.example.employeeinfo.loginPage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.employeeinfo.MainActivity
import com.example.employeeinfo.R

class LoginActivity : AppCompatActivity() {
    lateinit var et_email : EditText
    lateinit var et_password : EditText
    lateinit var btn_submit : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login2)

        et_email = findViewById(R.id.et_email)
        et_password = findViewById(R.id.et_pass)
        btn_submit = findViewById(R.id.btn_login)

        val dummy_email = "abc"
        val dummy_password = "12345"

       btn_submit.setOnClickListener{

           val email : String = et_email.text.toString()
           val password : String = et_password.text.toString()

           Log.d("LoginActivity",email+" "+password)
           //Toast.makeText(this,email+" "+password,Toast.LENGTH_LONG).show()

           if(email == dummy_email && password == dummy_password)
           {
               val intent = Intent(this, MainActivity::class.java)
               startActivity(intent)
           }
           else{
               Toast.makeText(this,"Invalid Credentials",Toast.LENGTH_LONG).show()
           }

       }

    }
}