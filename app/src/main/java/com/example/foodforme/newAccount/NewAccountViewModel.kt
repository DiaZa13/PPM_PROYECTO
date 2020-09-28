package com.example.foodforme.newAccount

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.*

class NewAccountViewModel(): ViewModel() {

    val user = MutableLiveData<String>()
    val password = MutableLiveData<String>()
    val name = MutableLiveData<String>()

    private val _newUser = MutableLiveData<Boolean>()
    val newUser: LiveData<Boolean>
        get() = _newUser

    private val _error = MutableLiveData<Int>()
    val error: LiveData<Int>
        get() = _error


    fun newAccount(){

        FirebaseAuth.getInstance()
            .createUserWithEmailAndPassword(user.value!!, password.value!!)
            .addOnCompleteListener{
               if(it.isSuccessful){
                    _newUser.value = true
               }else{
                   _newUser.value = false
                   try{
                       throw it.exception!!.fillInStackTrace()
                   }catch(e: FirebaseAuthWeakPasswordException){
                       _error.value = 1
                   }catch (e: FirebaseAuthInvalidCredentialsException){
                       _error.value = 2
                   }catch (e: FirebaseAuthUserCollisionException){
                       _error.value = 3
                   }
                   Log.w("NewAccountViewModel", it.exception)
               }
            }


    }

}
