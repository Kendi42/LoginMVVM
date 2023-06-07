package com.example.loginmvvm.data.repository

import com.example.loginmvvm.data.UserPreferences
import com.example.loginmvvm.data.network.AuthAPI
import com.example.loginmvvm.data.request.LoginRequest
import com.example.loginmvvm.data.responses.LoginData
import com.example.loginmvvm.data.roomdb.AppDatabase
import com.example.loginmvvm.data.roomdb.UserDataDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class AuthRepository @Inject constructor(private val api: AuthAPI, private val preferences: UserPreferences, private val appDatabase: AppDatabase): BaseRepository() {

    suspend fun login(username: String, password: String) = safeApiCall {
        api.login(LoginRequest(username=username, password=password)) // named arguments
    }

    suspend fun saveAuthToken(token: String){
        preferences.saveAuthToken(token)
    }

    suspend fun saveUserData(loginData: LoginData){
        appDatabase.userDataDao().insertData(loginData)
    }

    fun getUserData(): Flow<LoginData> {
        return appDatabase.userDataDao().getUser()
    }

}