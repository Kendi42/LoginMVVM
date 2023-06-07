package com.example.loginmvvm.di

import com.example.loginmvvm.ui.auth.LoginFragment
import dagger.Module
//import dagger.android.ContributesAndroidInjector


@Module
abstract class LoginFragmentModule {

    //@ContributesAndroidInjector
    abstract fun contributesLoginFragmentInjector(): LoginFragment
}