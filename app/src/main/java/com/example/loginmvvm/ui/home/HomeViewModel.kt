package com.example.loginmvvm.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.loginmvvm.data.network.Resource
import com.example.loginmvvm.data.repository.UserRepository
import com.example.loginmvvm.data.responses.LoginResponse
import kotlinx.coroutines.launch

class HomeViewModel (
    private val repository: UserRepository

): ViewModel(){
    private val _data: MutableLiveData<Resource<LoginResponse>> = MutableLiveData()
    val data: LiveData<Resource<LoginResponse>>
    get()= _data

    // Get the user by calling the repository function
    fun getData() = viewModelScope.launch {
        _data.value = Resource.Loading // Loading state
        _data.value= repository.getData()
    }
}