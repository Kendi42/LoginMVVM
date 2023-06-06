package com.example.loginmvvm.data.network

import com.example.loginmvvm.data.request.LoginRequest
import com.example.loginmvvm.data.responses.LoginResponse
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface AuthAPI {

    //@FormUrlEncoded
    // Defining the URL end point
    // POST because the login API accepts a POST request
    @POST("auth/login")
    // Function to facilitate login
    suspend fun login(
       // @Field("username") username: String,
       // @Field("password") password: String
        @Body loginRequest: LoginRequest
    ): LoginResponse




}