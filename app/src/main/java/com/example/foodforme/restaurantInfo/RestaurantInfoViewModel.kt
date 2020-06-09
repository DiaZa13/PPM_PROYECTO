package com.example.foodforme.restaurantInfo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.foodforme.data.Fb_restaurantes
import com.example.foodforme.data.Restaurant

class RestaurantInfoViewModel(restaurant: Fb_restaurantes) : ViewModel(){
    private val _restaurante = MutableLiveData<Fb_restaurantes>(restaurant)
    val restaurante : LiveData<Fb_restaurantes>
        get() = _restaurante

    /*init {
        _restaurante.value = Restaurant("0", "Burger King", "22000000", "En el mundo", 3,"Hamburguesas")
    }*/
}