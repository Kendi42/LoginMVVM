package com.example.loginmvvm.ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.loginmvvm.data.repository.AuthRepository
import com.example.loginmvvm.data.repository.BaseRepository
import com.example.loginmvvm.ui.auth.AuthViewModel


@Suppress("UNCHECKED_CAST")
class ViewModelFactory(
    private val repository: BaseRepository
): ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when{
            modelClass.isAssignableFrom(AuthViewModel::class.java)-> AuthViewModel(repository as AuthRepository) as T
            else-> throw IllegalArgumentException("ViewModel Class Not Found")
        }

    }


}