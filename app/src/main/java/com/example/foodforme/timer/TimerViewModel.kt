package com.example.foodforme.timer

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import java.util.*

class TimerViewModel : ViewModel() {

    val liters = MutableLiveData<Long>()
    val date = Date()

    private val _error = MutableLiveData<Int>()
    val error: LiveData<Int>
        get() = _error

    fun spentLiters(){

    }

    // TODO: Implement the ViewModel
}
