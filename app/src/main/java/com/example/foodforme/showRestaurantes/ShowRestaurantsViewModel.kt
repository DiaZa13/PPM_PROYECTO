package com.example.foodforme.showRestaurantes

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.foodforme.data.Restaurant
import com.example.foodforme.data.Restaurante
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.ktx.Firebase

class ShowRestaurantsViewModel: ViewModel(){


    private val _datos = MutableLiveData<List<Restaurante>>()

    val datos: LiveData<List<Restaurante>>
        get() = _datos

    init{
        val ref = FirebaseDatabase.getInstance().getReference("restaurantes")
        ref.addValueEventListener(object:ValueEventListener{
            @SuppressLint("LongLogTag")
            override fun onDataChange(p0: DataSnapshot) {
                if (p0!!.exists()){
                    for(i in p0.children){
                        var restaurant = i.getValue(Restaurante::class.java)
                        if (restaurant != null) {
                            _datos.value = mutableListOf(
                                restaurant
                            )
                            Log.i("Restaurant",restaurant.id+ restaurant.direction+ restaurant.name )

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