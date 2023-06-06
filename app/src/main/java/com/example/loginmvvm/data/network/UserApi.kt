package com.example.loginmvvm.data.network

import com.example.loginmvvm.data.request.LoginRequest
import com.example.loginmvvm.data.responses.LoginResponse
import retrofit2.http.GET

interface UserApi {
    @GET("data")
    suspend fun getData():LoginResponse
}