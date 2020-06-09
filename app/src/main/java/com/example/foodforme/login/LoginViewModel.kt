package com.example.foodforme.login


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.*

class LoginViewModel (): ViewModel() {

    val user = MutableLiveData<String>()
    val password = MutableLiveData<String>()

    private val _isUser = MutableLiveData<Boolean>()
    val isUser: LiveData<Boolean>
        get() = _isUser


    var usersIndex = 0
        private set

    private val viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)



}
