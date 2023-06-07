package com.example.loginmvvm.data.roomdb

import androidx.room.*
import com.example.loginmvvm.data.responses.LoginData
import kotlinx.coroutines.flow.Flow

const val ROOM_DB_CURRENT_USER_ID= 0
@Dao
interface UserDataDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertData(user: LoginData)

    @Query("SELECT * FROM LoginData WHERE uid=$ROOM_DB_CURRENT_USER_ID")
    fun getUser(): Flow<LoginData>

    @Delete
    fun delete(user: LoginData)


}