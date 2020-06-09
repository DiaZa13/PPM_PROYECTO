package com.example.foodforme.showRestaurantes

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.foodforme.data.Fb_restaurantes
import com.example.foodforme.data.Restaurant
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.ktx.Firebase

class ShowRestaurantsViewModel: ViewModel(){


    private val _datos = MutableLiveData<List<Fb_restaurantes>>()
    val datos: LiveData<List<Fb_restaurantes>>
        get() = _datos

    private val _prueba = MutableLiveData<List<Restaurant>>()
    val prueba: LiveData<List<Restaurant>>
        get() = _prueba

    init{
        val ref = FirebaseDatabase.getInstance().getReference("restaurantes")
        ref.addValueEventListener(object:ValueEventListener{
            @SuppressLint("LongLogTag")
            override fun onDataChange(p0: DataSnapshot) {
                if (p0!!.exists()){
                    for(i in p0.children){
                        var restaurant = i.getValue(Restaurant::class.java)
                        if (restaurant != null) {
                            _datos.value = mutableListOf(
                                Fb_restaurantes(restaurant.id,restaurant.direction,restaurant.name,restaurant.phone,restaurant.rating,restaurant.type)
                            )

                        }
                    }
                }
            }
            override fun onCancelled(p0: DatabaseError) {
                println(p0.toException())
            }
        })


    }

}