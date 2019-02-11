package com.example.designsupportlibrarydemo

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_text_input_layout.*
import java.util.regex.Pattern

class TextInputLayoutActivity : AppCompatActivity() {


    private val EMAIL_PATTERN = "^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+\$"
    private val pattern = Pattern.compile(EMAIL_PATTERN)

    companion object {

        fun launch(context: Context) {
            val intent = Intent(context, TextInputLayoutActivity::class.java)
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_text_input_layout)
        btnLogin.setOnClickListener {
            login()
        }
    }

    private fun login() {
        val userName = tilUserName.editText?.text.toString()
        val password = tilPassword.editText?.text.toString()
        if (!validateUserName(userName)) {
            tilUserName.isErrorEnabled = true
            tilUserName.error = "Please input valid email"
        } else if (!validatePassword(password)) {
            tilPassword.isErrorEnabled = true
            tilPassword.error = "Please input correct password"
        } else {
            tilUserName.isErrorEnabled = false
            tilPassword.isErrorEnabled = false
            Toast.makeText(this, "Login success", Toast.LENGTH_SHORT).show()

        }

    }

    fun validateUserName(userName: String): Boolean {
        val matcher = pattern.matcher(userName)
        return matcher.matches()

    }

    fun validatePassword(password: String): Boolean {

        return password.length > 6

    }
}
