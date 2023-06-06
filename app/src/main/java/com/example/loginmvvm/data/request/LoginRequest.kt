package com.example.loginmvvm.data.request


import com.google.gson.annotations.SerializedName

data class LoginRequest(
    @SerializedName("password")
    val password: String,
    @SerializedName("username")
    val username: String // 97M0Y12BNWEJAQP
)