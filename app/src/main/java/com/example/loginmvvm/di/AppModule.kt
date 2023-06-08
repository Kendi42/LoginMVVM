package com.example.loginmvvm.di

import android.content.Context
import com.example.loginmvvm.data.UserPreferences
import com.example.loginmvvm.data.network.AuthAPI
import com.example.loginmvvm.data.network.RemoteDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)

class AppModule {
    @Singleton
    @Provides
    fun provideAuthApi(remoteDataSource: RemoteDataSource): AuthAPI{
        return remoteDataSource.buildApi(AuthAPI::class.java, "")
    }


    @Singleton
    @Provides
    fun provideUserPreferences(context:Context): UserPreferences{
        return UserPreferences(context)
    }



}