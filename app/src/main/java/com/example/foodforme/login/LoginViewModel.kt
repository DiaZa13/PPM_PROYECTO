package com.example.foodforme.login

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.foodforme.database.UserDatabaseDao
import kotlinx.coroutines.*

class LoginViewModel (val database:UserDatabaseDao): ViewModel() {

    val user = MutableLiveData<String>()
    val password = MutableLiveData<String>()

    private val _isUser = MutableLiveData<Boolean>()
    val isUser: LiveData<Boolean>
        get() = _isUser


    private val viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    init{
        _isUser.value = false;
    }

    fun verifiedUser(userInput:String) {
        uiScope.launch {
            verified(userInput)
        }
    }


    private suspend fun verified(userInput:String) {
        withContext(Dispatchers.IO) {
            val dbUser = database.getUser("FFM")
           Log.i("LoginViewModel", dbUser?.user)
            if (user.value.equals(dbUser?.user)) {
                if (password.value.equals(dbUser?.password)) {
                    _isUser.postValue(true)
                }
            } else {
                _isUser.postValue(false)
            }
        }
    }

}
