package com.example.loginmvvm.ui.home

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import com.example.loginmvvm.R
import com.example.loginmvvm.data.network.AuthAPI
import com.example.loginmvvm.data.network.Resource
import com.example.loginmvvm.data.network.UserApi
import com.example.loginmvvm.data.repository.AuthRepository
import com.example.loginmvvm.data.repository.UserRepository
import com.example.loginmvvm.data.responses.LoginData
import com.example.loginmvvm.data.responses.LoginResponse
import com.example.loginmvvm.data.roomdb.AppDatabase
import com.example.loginmvvm.databinding.FragmentHomeBinding
import com.example.loginmvvm.databinding.FragmentLoginBinding
import com.example.loginmvvm.ui.auth.AuthViewModel
import com.example.loginmvvm.ui.base.BaseFragment
import com.example.loginmvvm.ui.enable
import com.example.loginmvvm.ui.visible
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class HomeFragment : BaseFragment<AuthViewModel, FragmentHomeBinding, AuthRepository>() {
    //
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.progressBarHome.visible(false)

        lifecycleScope.launch {
            viewModel.getUserData().collect {
                updateUI(it)
            }
        }
        binding.btnLogout.setOnClickListener {
            logout()
        }
    }

    private fun updateUI(data: LoginData) {
        with(binding) {
            tvId.text = data.user.idNumber
            tvName.text = data.user.name
            tvEmail.text = data.user.email
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
        AppDatabase(requireContext())
    )


}