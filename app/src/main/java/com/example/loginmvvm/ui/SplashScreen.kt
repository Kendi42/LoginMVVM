package com.example.loginmvvm.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.asLiveData
import com.example.loginmvvm.R
import com.example.loginmvvm.data.UserPreferences
import com.example.loginmvvm.ui.auth.AuthActivity
import com.example.loginmvvm.ui.home.HomeActivity

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Hide Action Bar
        supportActionBar?.hide();

        val userPreferences = UserPreferences(this)

        userPreferences.authToken.asLiveData().observe(this, Observer{
            Toast.makeText(this, it?: "Token is Null", Toast.LENGTH_SHORT).show()
            val activity = if(it== null) AuthActivity::class.java else HomeActivity::class.java
            startNewActivity(activity)
            // Time Splash screen
            val secondsDelayed= 1
            Handler().postDelayed({
                startActivity(Intent(this@SplashScreen, AuthActivity::class.java))
                finish()
            }, secondsDelayed * 1000L)
        })
    }
}