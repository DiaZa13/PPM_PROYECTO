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

    @Query("SELECT * FROM user_table WHERE user = :userInput")
    fun getUser(userInput: String): LiveData<User>

}