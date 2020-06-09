package com.example.foodforme.login


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel (): ViewModel() {

    val user = MutableLiveData<String>()
    val password = MutableLiveData<String>()

    private val _isUser = MutableLiveData<Boolean>()
    val isUser: LiveData<Boolean>
        get() = _isUser




}
