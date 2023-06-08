package com.example.loginmvvm.ui

import android.app.Application
import com.example.loginmvvm.di.AppModule
import com.example.loginmvvm.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject


class MyApplication : Application(), HasAndroidInjector {

    @Inject
    lateinit var mInjector: DispatchingAndroidInjector<Any>

    override fun onCreate() {
        super.onCreate()
        DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .build()
            .inject(this) // injecting all the dependencies
    }

    override fun androidInjector(): AndroidInjector<Any> {
        return mInjector
    }


}