package com.example.foodforme.newAccount

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.foodforme.database.UserDatabaseDao

class NewAccountViewModelFactory(private val database: UserDatabaseDao) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(NewAccountViewModel::class.java)) {
            return NewAccountViewModel(database) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}