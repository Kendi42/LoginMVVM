package com.example.loginmvvm.ui.auth

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.loginmvvm.R
import com.example.loginmvvm.databinding.FragmentLoginBinding
import com.example.loginmvvm.data.network.Resource
import com.example.loginmvvm.ui.enable
import com.example.loginmvvm.ui.handleApiError
import com.example.loginmvvm.ui.visible
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class LoginFragment : Fragment(R.layout.fragment_login) {
    private lateinit var binding:FragmentLoginBinding
    private val viewModel: AuthViewModel by viewModels()
    override fun onAttach(context: Context) {
        super.onAttach(context)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding= FragmentLoginBinding.bind(view)

        binding.loginProgressBar.visible(false)
        binding.btnLogin.enable(false)

        // To observe the Login response
        viewModel?.loginResponse?.observe(viewLifecycleOwner, Observer {
            binding.loginProgressBar.visible(it is Resource.Loading)
            when(it){
                is Resource.Success ->{
                    val response = it.value
                    if(response.status == 1){
                        lifecycleScope.launch {
                            // Save Token and AL  response data
                            viewModel.saveAuthToken(response.data.token!!) // Exclamation marks may cause a null point exception
                            viewModel.saveUserData(response.data)
                            Toast.makeText(requireContext(), it.toString(), Toast.LENGTH_LONG).show()
                            /*requireActivity().startNewActivity(HomeActivity::class.java)*/
                            findNavController().navigate(R.id.action_loginFragment_to_homeFragment2)
                        }

                    }else{

                    }

                }
                is Resource.Loading ->{
                    Log.d("Resource Loading", "Resource Loading")
                }
                is Resource.Failure -> handleApiError(it){login()}
            }
        })

        binding.etLoginPass.addTextChangedListener{
            val username = binding.etLoginUsername.text.toString().trim()
            binding.btnLogin.enable(username.isNotEmpty() && it.toString().isNotEmpty())

        }

        binding.btnLogin.setOnClickListener{
            login()
        }
    }

    private fun login() {
        val userName= binding.etLoginUsername.text.toString().trim()
        Log.d("API message", "UserName: $userName")

        val password= binding.etLoginPass.text.toString().trim()
        Log.d("API message", "Password: $password")

        viewModel.login(userName, password)
    }

//    override fun getViewModel() = AuthViewModel::class.java
//    override fun getFragmentBinding(
//        inflater: LayoutInflater,
//        container: ViewGroup?
//    ) = FragmentLoginBinding.inflate(inflater, container, false)
//
//    override fun getFragmentRepository() = AuthRepository(remoteDataSource.buildApi(AuthAPI::class.java), userPreferences,AppDatabase(requireContext()))


}