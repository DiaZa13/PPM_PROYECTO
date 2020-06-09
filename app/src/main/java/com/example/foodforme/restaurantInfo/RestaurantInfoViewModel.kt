package com.example.foodforme.restaurantInfo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.foodforme.data.Restaurant

class RestaurantInfoViewModel : ViewModel(){

    private val _restaurante = MutableLiveData<Restaurant>()
    val restaurante : LiveData<Restaurant>
        get() = _restaurante

    init {
        _restaurante.value = Restaurant("Burger King", "22000000", "En el mundo", 4.3f, "Hamburguesas")
    }
}