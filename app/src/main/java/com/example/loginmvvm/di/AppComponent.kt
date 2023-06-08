package com.example.loginmvvm.di

import com.example.loginmvvm.ui.MyApplication
import dagger.Component
import dagger.android.AndroidInjectionModule

@Component(modules = [
    AndroidInjectionModule::class,
    LoginFragmentModule::class,
    AppModule::class
])
interface AppComponent {
    fun inject(application: MyApplication)



}