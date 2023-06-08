package com.example.loginmvvm.di

import com.example.loginmvvm.ui.auth.LoginFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class LoginFragmentModule {
    // Injector Function That will provide the injector
    @ContributesAndroidInjector
    abstract fun contributesLoginFragmentInjector(): LoginFragment
}