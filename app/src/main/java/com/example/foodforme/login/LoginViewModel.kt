package com.example.foodforme.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.foodforme.database.UserDatabaseDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job

class LoginViewModel (val database:UserDatabaseDao): ViewModel() {

    val user = MutableLiveData<String>()
    val password = MutableLiveData<String>()

    val dbUser = database.getUser(user.value!!)

    private val viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)


}
