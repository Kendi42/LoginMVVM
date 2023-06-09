package com.example.loginmvvm.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import com.example.loginmvvm.data.network.AuthAPI
import com.example.loginmvvm.data.repository.AuthRepository
import com.example.loginmvvm.data.responses.LoginData
import com.example.loginmvvm.databinding.FragmentHomeBinding
import com.example.loginmvvm.ui.auth.AuthViewModel
import com.example.loginmvvm.ui.base.BaseFragment
import com.example.loginmvvm.ui.visible
import kotlinx.coroutines.launch

class HomeFragment : BaseFragment<AuthViewModel, FragmentHomeBinding, AuthRepository>() {
    //
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.progressBarHome.visible(false)
        binding.btnLogout.setOnClickListener {
            logout()
        }
    }


    /*override fun getViewModel() = HomeViewModel::class.java

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentHomeBinding.inflate(inflater, container, false)

    override fun getFragmentRepository(): UserRepository {
        val token =
            runBlocking { userPreferences.authToken.first() } // Run blocking may cause an ANR-
        val api = remoteDataSource.buildApi(UserApi::class.java, token)
        return UserRepository(api)
    }*/

    override fun getViewModel() = AuthViewModel::class.java
    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentHomeBinding.inflate(inflater, container, false)

    override fun getFragmentRepository() = AuthRepository(
        remoteDataSource.buildApi(AuthAPI::class.java), userPreferences,
    )


}