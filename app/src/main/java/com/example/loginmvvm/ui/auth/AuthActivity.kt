package com.example.loginmvvm.ui.auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.loginmvvm.R
import dagger.android.AndroidInjection

class AuthActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)

        // Hide Action Bar
        supportActionBar?.hide()


//
//        signupInstead.setOnClickListener {
//            startActivity(Intent(this@Login, Signup::class.java))
//            finish()
//        }


    }
}