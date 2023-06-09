package com.example.loginmvvm.di

import android.content.Context
import com.example.loginmvvm.data.UserPreferences
import com.example.loginmvvm.data.network.AuthAPI
import com.example.loginmvvm.data.network.RemoteDataSource
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(
    private val context: Context

) {
    // Needs to build the interfaces Auth API and UserInterfaces

    @Singleton
    @Provides
    fun provideAuthApi(remoteDataSource: RemoteDataSource): AuthAPI{
        return remoteDataSource.buildApi(AuthAPI::class.java)
    }


    @Singleton
    @Provides
    fun provideUserPreferences(): UserPreferences{
        return UserPreferences(context)
    }

//    @Singleton
//    @Provides
//    fun provideAppDatabase(): AppDatabase{
//        return AppDatabase(context)
//    }



}