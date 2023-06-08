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
    // Since its an interface we cant directly instantiate an interface for dependency injection
    //When in situations like this, one needs to create a module to construct the dependecies that are not possible to inject

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