package com.example.foodforme.newAccount


import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.*
import com.google.firebase.database.FirebaseDatabase

class NewAccountViewModel(): ViewModel() {

    val user = MutableLiveData<String>()
    val password = MutableLiveData<String>()
    val name = MutableLiveData<String>()

    private var database: FirebaseDatabase = FirebaseDatabase.getInstance()




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
                   var users = database.getReference("users/" + FirebaseAuth.getInstance().currentUser!!.uid)
                    users!!.child("name").setValue(name.value)
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
