package com.example.foodforme.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

/**
* Defines methods for using the User class with Room.
*/
@Dao
interface UserDatabaseDao {

    @Insert
    fun insert(user: User)

    @Query("SELECT * FROM user_table")
    fun getUsers(): LiveData<List<User>>

}