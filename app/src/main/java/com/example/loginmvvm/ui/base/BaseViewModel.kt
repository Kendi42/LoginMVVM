package com.example.loginmvvm.ui.base

import androidx.lifecycle.ViewModel
import com.example.loginmvvm.data.network.UserApi
import com.example.loginmvvm.data.repository.BaseRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

open class BaseViewModel(
    private val repository: BaseRepository

): ViewModel(){

    suspend fun logout(api: UserApi) = withContext(Dispatchers.IO){repository.logout(api)
    }
}