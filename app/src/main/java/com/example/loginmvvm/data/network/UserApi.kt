package com.example.loginmvvm.data.network

import com.example.loginmvvm.data.request.LoginRequest
import com.example.loginmvvm.data.responses.LoginResponse
import okhttp3.ResponseBody
import retrofit2.http.GET
import retrofit2.http.POST

interface UserApi {
    @GET("data")
    suspend fun getData():LoginResponse

    @POST("logout")
    suspend fun logout():ResponseBody

}