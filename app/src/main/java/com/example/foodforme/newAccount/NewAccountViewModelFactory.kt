package com.example.foodforme.newAccount

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class NewAccountViewModelFactory() : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(NewAccountViewModel::class.java)) {
            return NewAccountViewModel() as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}