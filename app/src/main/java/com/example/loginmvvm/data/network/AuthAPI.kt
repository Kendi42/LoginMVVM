package com.example.loginmvvm.data.network

import com.example.loginmvvm.data.request.LoginRequest
import com.example.loginmvvm.data.responses.LoginResponse
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

// Class where functions for interacting with the API for Authentication are defined
/*
* It accepts a LoginRequest object as the request body and returns a LoginResponse object.*/
interface AuthAPI {
    @POST("auth/login")
    suspend fun login(
        @Body loginRequest: LoginRequest
    ): LoginResponse

}