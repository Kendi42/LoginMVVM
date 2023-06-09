package com.example.loginmvvm.di

import com.example.loginmvvm.ui.MyApplication
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidInjectionModule::class,
    LoginFragmentModule::class,
    AppModule::class,
    ActivityModule::class
])
interface AppComponent {
    fun inject(application: MyApplication)



}