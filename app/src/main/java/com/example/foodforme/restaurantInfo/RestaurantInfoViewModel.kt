package com.example.foodforme.restaurantInfo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.foodforme.data.Restaurant

class RestaurantInfoViewModel(restaurant: Restaurant) : ViewModel(){
    private val _restaurante = MutableLiveData<Restaurant>(restaurant)
    val restaurante : LiveData<Restaurant>
        get() = _restaurante

    /*init {
        _restaurante.value = Restaurant("0", "Burger King", "22000000", "En el mundo", 3,"Hamburguesas")
    }*/
}