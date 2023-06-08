package com.example.loginmvvm.ui

import android.app.Application
import com.example.loginmvvm.di.AppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject


@HiltAndroidApp
class MyApplication : Application()/*, HasAndroidInjector*/ {

//    @Inject
//    lateinit var mInjector: DispatchingAndroidInjector<Any>
//    override fun onCreate(){
//        super.onCreate()
////        DaggerAppComponent.builder()
//    }


    //    override fun androidInjector(): AndroidInjector<Any> {
//        return mInjector
//    }


}