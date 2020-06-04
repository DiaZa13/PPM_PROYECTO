package com.example.foodforme.newAccount

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.foodforme.database.User
import com.example.foodforme.database.UserDatabaseDao
import kotlinx.coroutines.*

class NewAccountViewModel(val database: UserDatabaseDao): ViewModel() {

    val name = MutableLiveData<String>()
    val userv = MutableLiveData<String>()
    val email = MutableLiveData<String>()
    val password = MutableLiveData<String>()

    private val viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    fun insertGuest(user: Any) {
        uiScope.launch {
            insert(user as User)
        }
    }

    private suspend fun insert(user: User){
        withContext(Dispatchers.IO) {
            database.insert(User(name = name.value?:"", user = userv.value?:"",email = email.value?:"", password = password.value?: ""))
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}
