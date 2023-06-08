package com.example.loginmvvm.di

import com.example.loginmvvm.ui.MyApplication
import dagger.Component
import dagger.android.AndroidInjectionModule
// This is the appcomponent/ application graph
@Component(modules = [
    AndroidInjectionModule::class,
    LoginFragmentModule::class,
    AppModule::class
])
interface AppComponent {
    // Function that performs the injection
    fun inject(application: MyApplication)
}