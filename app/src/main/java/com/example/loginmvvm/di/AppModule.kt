package com.example.loginmvvm.di

import android.content.Context
import com.example.loginmvvm.data.UserPreferences
import com.example.loginmvvm.data.network.AuthAPI
import com.example.loginmvvm.data.network.RemoteDataSource
import com.example.loginmvvm.data.roomdb.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule{
//    // Needs to build the interfaces Auth API and UserInterfaces
//
//    @Singleton
    @Provides
    fun provideAuthApi(remoteDataSource: RemoteDataSource): AuthAPI{
        return remoteDataSource.buildApi(AuthAPI::class.java)
    }
//
//    @Singleton
//    @Provides
//    fun provideUserPreferences(): UserPreferences{
//        return UserPreferences(context)
//    }
//
//    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext context:Context): AppDatabase {
        return AppDatabase(context)
    }



}