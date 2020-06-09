package com.example.foodforme.showOfertas

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.foodforme.data.Oferta

class ShowOfertasViewModel : ViewModel(){

    private val _datos = MutableLiveData<List<Oferta>>()
    val datos: LiveData<List<Oferta>>
        get() = _datos

    init {

        _datos.value = listOf(
            Oferta("Restaurante A", "Menu 1", 1.0),
            Oferta("Restaurante B", "Menu 2", 2.0),
            Oferta("Restaurante C", "Menu 3", 3.0),
            Oferta("Restaurante D", "Menu 4", 4.0),
            Oferta("Restaurante E", "Menu 5", 5.0),
            Oferta("Restaurante F", "Menu 6", 6.0),
            Oferta("Restaurante G", "Menu 7", 7.0)
        )

    }
}