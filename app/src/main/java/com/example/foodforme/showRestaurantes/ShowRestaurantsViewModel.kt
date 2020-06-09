package com.example.foodforme.showRestaurantes

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.foodforme.data.Restaurant

class ShowRestaurantsViewModel: ViewModel(){


    private val _datos = MutableLiveData<List<Restaurant>>()
    val datos: LiveData<List<Restaurant>>
        get() = _datos

    init{
        _datos.value = listOf(
            Restaurant("Restaurante A", "1111","Dirección A", 5f),
            Restaurant("Restaurante B", "2222","Dirección B", 4.5f),
            Restaurant("Restaurante C", "3333","Dirección C", 4f),
            Restaurant("Restaurante D", "4444","Dirección D", 3.5f),
            Restaurant("Restaurante E", "5555","Dirección E", 3f),
            Restaurant("Restaurante F", "6666","Dirección F", 3.2f),
            Restaurant("Restaurante G", "7777","Dirección G", 1f)
            )
    }

}