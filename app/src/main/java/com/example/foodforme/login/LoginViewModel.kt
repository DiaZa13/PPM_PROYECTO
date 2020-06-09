package com.example.foodforme.login


import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth

class LoginViewModel (): ViewModel() {

    val user = MutableLiveData<String>()
    val password = MutableLiveData<String>()

    private val _isUser = MutableLiveData<Boolean>()
    val isUser: LiveData<Boolean>
        get() = _isUser

    private val _error = MutableLiveData<Int>()
    val error: LiveData<Int>
        get() = _error

    fun logIn(){
        FirebaseAuth.getInstance()
            .signInWithEmailAndPassword(user.value!!, password.value!!)
            .addOnCompleteListener{
                if(it.isSuccessful){
                    _isUser.value = true
                }else{
                    _isUser.value = false
                    Log.w("NewAccountViewModel", it.exception)
                    
                }
            }
    }


}
