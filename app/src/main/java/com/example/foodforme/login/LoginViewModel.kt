package com.example.foodforme.login

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.foodforme.database.User
import com.example.foodforme.database.UserDatabaseDao
import kotlinx.coroutines.*

class LoginViewModel (val database:UserDatabaseDao): ViewModel() {

    val dbUser = database.getUsers()

    val user = MutableLiveData<String>()
    val password = MutableLiveData<String>()

    private val _isUser = MutableLiveData<Boolean>()
    val isUser: LiveData<Boolean>
        get() = _isUser


    var usersIndex = 0
        private set

    private val viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    init{
        _isUser.value = false;
    }

    fun isUser(dbUser: List<User>){
        usersIndex = dbUser.size
        var index = 1

        while(index < usersIndex){
                if(user.value == dbUser[index-1].user){
                    Log.i("LoginViewModel",dbUser[index-1].user)
                    if(password.value == dbUser[index-1].password)
                        _isUser.value = true
                }
                else
                    index ++
            }

    }


}
