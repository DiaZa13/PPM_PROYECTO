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
            Restaurant("Restaurante A", "1111","Dirección A", 5f, "Taco"),
            Restaurant("Restaurante B", "2222","Dirección B", 4.5f, "Hamburguesas"),
            Restaurant("Restaurante C", "3333","Dirección C", 4f, "Pollo"),
            Restaurant("Restaurante D", "4444","Dirección D", 3.5f, "Taco"),
            Restaurant("Restaurante E", "5555","Dirección E", 3f, "Pizza"),
            Restaurant("Restaurante F", "6666","Dirección F", 3.2f, "Pizza"),
            Restaurant("Restaurante G", "7777","Dirección G", 1f, "Taco" )
            )
    }

}