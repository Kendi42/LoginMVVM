package com.example.loginmvvm.ui

import android.app.Application
import dagger.hilt.android.HiltAndroidApp


@HiltAndroidApp
class MyApplication : Application() {

//    @Inject
//    lateinit var mInjector: DispatchingAndroidInjector<Any>
//
//    override fun onCreate() {
//        super.onCreate()
//        DaggerAppComponent.builder()
//            .appModule(AppModule(this))
//            .build()
//            .inject(this) // injecting all the dependencies
//    }
//
//    override fun androidInjector(): AndroidInjector<Any> {
//        return mInjector
//    }


}