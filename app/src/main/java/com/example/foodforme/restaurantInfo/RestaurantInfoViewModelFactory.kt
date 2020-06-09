package com.example.foodforme.restaurantInfo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.foodforme.data.Restaurant


class RestaurantInfoViewModelFactory(private val restaurant: Restaurant) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(RestaurantInfoViewModel::class.java)) {
            return RestaurantInfoViewModel(restaurant) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}