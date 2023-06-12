package com.example.loginmvvm.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.loginmvvm.R


class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)


        // Hide Action Bar
        supportActionBar?.hide();
    }
}