package com.example.loginmvvm.data.repository

import com.example.loginmvvm.data.UserPreferences
import com.example.loginmvvm.data.network.AuthAPI
import com.example.loginmvvm.data.network.UserApi
import com.example.loginmvvm.data.request.LoginRequest

class UserRepository(
    private val api: UserApi,

): BaseRepository() {
    suspend fun getData()= safeApiCall {
        api.getData()
    }

}