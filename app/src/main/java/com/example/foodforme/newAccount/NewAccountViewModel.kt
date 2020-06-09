package com.example.foodforme.newAccount

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.*

class NewAccountViewModel(): ViewModel() {

    val user = MutableLiveData<String>()
    val password = MutableLiveData<String>()

    private val _newUser = MutableLiveData<Boolean>()
    val newUser: LiveData<Boolean>
        get() = _newUser

    private val _error = MutableLiveData<String>()
    val error: LiveData<String>
        get() = _error

    fun newAccount(){
        FirebaseAuth.getInstance()
            .createUserWithEmailAndPassword(user.value!!, password.value!!)
            .addOnCompleteListener{
               if(it.isSuccessful){
                    _newUser.value = true
               }else{
                   _newUser.value = false
                   Log.w("NewAccountViewModel", it.exception)
               }
            }
    }

}
