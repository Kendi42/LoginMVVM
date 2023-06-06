package com.example.loginmvvm.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycling
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.viewbinding.ViewBinding
import com.example.loginmvvm.data.UserPreferences
import com.example.loginmvvm.data.network.RemoteDataSource
import com.example.loginmvvm.data.network.UserApi
import com.example.loginmvvm.data.repository.BaseRepository
import com.example.loginmvvm.ui.auth.AuthActivity
import com.example.loginmvvm.ui.startNewActivity
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import java.util.prefs.Preferences

// Every Fragment needs a ViewModel, ViewBinding, and a Repository
abstract class BaseFragment<VM: BaseViewModel, B: ViewBinding, R: BaseRepository>: Fragment() {
    protected lateinit var userPreferences: UserPreferences
    protected lateinit var binding: B
    protected lateinit var viewModel: VM
    protected val remoteDataSource= RemoteDataSource()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        userPreferences= UserPreferences(requireContext()) // We should use dependency injection for getting the instances
        binding= getFragmentBinding(inflater, container)
        val factory = ViewModelFactory(getFragmentRepository())
        viewModel= ViewModelProvider(this, factory)[getViewModel()]

        lifecycleScope.launch{userPreferences.authToken.first()}
        return binding.root
    }

    fun logout() = lifecycleScope.launch {
        val authToken = userPreferences.authToken.first()
        val api = remoteDataSource.buildApi(UserApi::class.java)
        viewModel.logout(api)
        userPreferences.clear()
        requireActivity().startNewActivity(AuthActivity::class.java)
    }

    abstract fun getViewModel(): Class<VM>

    abstract fun getFragmentBinding(inflater: LayoutInflater, container: ViewGroup?):B

    abstract fun getFragmentRepository(): R


}