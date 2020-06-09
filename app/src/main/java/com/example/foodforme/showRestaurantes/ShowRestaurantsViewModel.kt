package com.example.foodforme.showRestaurantes

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
        val ref = FirebaseDatabase.getInstance().getReference("restaurantes")
        ref.addValueEventListener(object:ValueEventListener{
            override fun onCancelled(p0: DatabaseError) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onDataChange(p0: DataSnapshot) {
                if (p0!!.exists()){
                    for(i in p0.children){
                        var restaurant = i.getValue(Restaurant::class.java)
                    }

                }
            }
        })
        _datos.value = listOf(
            Restaurant("Restaurante A", "1111","Dirección A", 5),
            Restaurant("Restaurante B", "2222","Dirección B", 4),
            Restaurant("Restaurante C", "3333","Dirección C", 4),
            Restaurant("Restaurante D", "4444","Dirección D", 3),
            Restaurant("Restaurante E", "5555","Dirección E", 3),
            Restaurant("Restaurante F", "6666","Dirección F", 3),
            Restaurant("Restaurante G", "7777","Dirección G", 1)
            )
    }

}