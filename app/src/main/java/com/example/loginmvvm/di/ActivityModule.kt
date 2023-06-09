package com.example.loginmvvm.di

import com.example.loginmvvm.ui.SplashScreen
import com.example.loginmvvm.ui.auth.AuthActivity
import com.example.loginmvvm.ui.auth.LoginFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {
    @ContributesAndroidInjector
    abstract fun contributesActivityInjector(): AuthActivity

    @ContributesAndroidInjector
    abstract fun contributesSplashActivityInjector(): SplashScreen
}