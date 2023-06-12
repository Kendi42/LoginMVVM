package com.example.loginmvvm.data

import android.content.Context
import androidx.datastore.DataStore
import androidx.datastore.preferences.*
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class UserPreferences @Inject constructor(@ApplicationContext context: Context) {
    private val applicationContext= context.applicationContext
    private val dataStore: DataStore<Preferences> = applicationContext.createDataStore(
        name= "datastore"
    )
    val authToken: Flow<String?>
    get()= dataStore.data.map{ preferences->
        preferences[KEY_AUTH]
    }

    suspend fun saveAuthToken(authToken:String){
        dataStore.edit {preferences ->
            preferences[KEY_AUTH] = authToken
        }
    }

    suspend fun clear(){
        dataStore.edit{ preferences ->
            preferences.clear()
        }
    }
    companion object{
        private val KEY_AUTH = preferencesKey<String>("key_auth")
    }
}