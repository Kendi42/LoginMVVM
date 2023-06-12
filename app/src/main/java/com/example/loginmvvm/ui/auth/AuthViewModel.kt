package com.example.loginmvvm.ui.auth

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.loginmvvm.data.network.Resource
import com.example.loginmvvm.data.repository.AuthRepository
import com.example.loginmvvm.data.responses.LoginData
import com.example.loginmvvm.data.responses.LoginResponse
import com.example.loginmvvm.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class AuthViewModel @Inject constructor(private val repository: AuthRepository): BaseViewModel(repository) {

    private val _loginResponse :MutableLiveData<Resource<LoginResponse>> = MutableLiveData()
    val loginResponse: LiveData<Resource<LoginResponse>>
        get()= _loginResponse

    fun login(
        username: String,
        password: String
    ) = viewModelScope.launch{
        _loginResponse.value= Resource.Loading
        _loginResponse.value = repository.login(username, password)
    }

    suspend fun saveAuthToken(token:String){
        repository.saveAuthToken(token)
    }

    suspend fun  saveUserData(loginData: LoginData)= repository.saveUserData(loginData)

    fun getUserData() = repository.getUserData()





}