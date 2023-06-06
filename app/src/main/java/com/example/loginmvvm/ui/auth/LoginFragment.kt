package com.example.loginmvvm.ui.auth

import android.nfc.Tag
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import com.example.loginmvvm.databinding.FragmentLoginBinding
import com.example.loginmvvm.data.network.AuthAPI
import com.example.loginmvvm.data.network.Resource
import com.example.loginmvvm.data.repository.AuthRepository
import com.example.loginmvvm.ui.base.BaseFragment
import com.example.loginmvvm.ui.enable
import com.example.loginmvvm.ui.home.HomeActivity
import com.example.loginmvvm.ui.startNewActivity
import com.example.loginmvvm.ui.visible
import kotlinx.coroutines.launch

class LoginFragment : BaseFragment<AuthViewModel, FragmentLoginBinding, AuthRepository>() {

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        binding.loginProgressBar.visible(false)
        binding.btnLogin.enable(false)
        // To observe the Login response
        viewModel.loginResponse.observe(viewLifecycleOwner, Observer {
            binding.loginProgressBar.visible(false)
            when(it){
                is Resource.Success ->{
                        viewModel.saveAuthToken(it.value.data.token)
                        Toast.makeText(requireContext(), it.toString(), Toast.LENGTH_LONG).show()
                        requireActivity().startNewActivity(HomeActivity::class.java)

                }
                is Resource.Failure ->{
                    Toast.makeText(requireContext(), "Login Failed: ${it.toString()}", Toast.LENGTH_LONG).show()
                    Log.d("API message", it.toString())
                }
            }
        })

        binding.etLoginPass.addTextChangedListener{
            val username = binding.etLoginUsername.text.toString().trim()
            binding.btnLogin.enable(username.isNotEmpty() && it.toString().isNotEmpty())

        }

        binding.btnLogin.setOnClickListener{
            val userName= binding.etLoginUsername.text.toString().trim()
            Log.d("API message", "UserName: $userName")

            val password= binding.etLoginPass.text.toString().trim()
            Log.d("API message", "Password: $password")

            //@todo add input validation
            binding.loginProgressBar.visible(true)
            viewModel.login(userName, password)
        }


    }

    override fun getViewModel() = AuthViewModel::class.java
    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentLoginBinding.inflate(inflater, container, false)

    override fun getFragmentRepository() = AuthRepository(remoteDataSource.buildApi(AuthAPI::class.java), userPreferences)


}