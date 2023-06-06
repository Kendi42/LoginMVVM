package com.example.loginmvvm.data.repository

import com.example.loginmvvm.data.UserPreferences
import com.example.loginmvvm.data.network.AuthAPI
import com.example.loginmvvm.data.request.LoginRequest

class AuthRepository(
    private val api: AuthAPI,
    private val preferences: UserPreferences

): BaseRepository() {

    suspend fun login(
        username: String,
        password: String
    ) = safeApiCall {
        api.login(LoginRequest(username=username, password=password)) // named arguments
    }

    suspend fun saveAuthToken(token: String){
        preferences.saveAuthToken(token)
    }

}