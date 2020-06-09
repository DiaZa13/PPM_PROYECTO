package com.example.foodforme.showRestaurantes

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.foodforme.data.Restaurant
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.ktx.Firebase

class ShowRestaurantsViewModel: ViewModel(){


    private val _datos = MutableLiveData<List<Restaurant>>()

    val datos: LiveData<List<Restaurant>>
        get() = _datos

    init{
        val ref = FirebaseDatabase.getInstance().getReference("restaurant")
        ref.addValueEventListener(object:ValueEventListener{
            @SuppressLint("LongLogTag")
            override fun onDataChange(p0: DataSnapshot) {
                if (p0!!.exists()){
                    for(i in p0.children){
                        var restaurant = i.getValue(Restaurant::class.java)
                        if (restaurant != null) {
                            _datos.value = listOf(
                                

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