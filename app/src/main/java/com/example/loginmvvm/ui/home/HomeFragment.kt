package com.example.loginmvvm.ui.home

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import com.example.loginmvvm.R
import com.example.loginmvvm.data.network.Resource
import com.example.loginmvvm.data.network.UserApi
import com.example.loginmvvm.data.repository.UserRepository
import com.example.loginmvvm.data.responses.LoginResponse
import com.example.loginmvvm.databinding.FragmentHomeBinding
import com.example.loginmvvm.ui.base.BaseFragment
import com.example.loginmvvm.ui.enable
import com.example.loginmvvm.ui.visible
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking

class HomeFragment : BaseFragment<HomeViewModel, FragmentHomeBinding, UserRepository>(){
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_home, container, false)
//    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.progressBarHome.visible(false)

        viewModel.getData()

        viewModel.data.observe(viewLifecycleOwner, Observer{
            when(it){
                is Resource.Success ->{
                    binding.progressBarHome.visible(false)
                    updateUI(it.value.data)
                    Toast.makeText(requireContext(), "Success Home", Toast.LENGTH_SHORT).show()

                }
                is Resource.Loading ->{
                    binding.progressBarHome.visible(true)

                }
                is Resource.Failure -> {
                    binding.progressBarHome.visible(false)
                    Toast.makeText(requireContext(), "Resource Failure Home", Toast.LENGTH_SHORT).show()
                    Log.d("Resource Failure Home", "Resource Failure Home")
                }
            }


        })
    }

    private fun updateUI(data: LoginResponse.Data) {
        with(binding){
            tvId.text= data.user.idNumber
            tvName.text = data.user.name
            tvEmail.text= data.user.email
        }
    }

    override fun getViewModel() = HomeViewModel::class.java

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentHomeBinding.inflate(inflater, container, false)

    override fun getFragmentRepository(): UserRepository {
        val token = runBlocking{userPreferences.authToken.first()} // Run blocking may cause an ANR-
        val api = remoteDataSource.buildApi(UserApi::class.java, token)
        return UserRepository(api)
    }

}