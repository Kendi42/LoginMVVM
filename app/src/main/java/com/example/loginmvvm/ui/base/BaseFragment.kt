package com.example.loginmvvm.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.viewbinding.ViewBinding
import com.example.loginmvvm.data.UserPreferences
import com.example.loginmvvm.data.network.RemoteDataSource
import com.example.loginmvvm.data.repository.BaseRepository
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import java.util.prefs.Preferences

// Every Fragment needs a ViewModel, ViewBinding, and a Repository
abstract class BaseFragment<VM: ViewModel, B: ViewBinding, R: BaseRepository>: Fragment() {
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

    abstract fun getViewModel(): Class<VM>

    abstract fun getFragmentBinding(inflater: LayoutInflater, container: ViewGroup?):B

    abstract fun getFragmentRepository(): R


}