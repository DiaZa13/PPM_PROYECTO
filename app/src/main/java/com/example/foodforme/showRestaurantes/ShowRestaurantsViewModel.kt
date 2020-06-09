package com.example.foodforme.showRestaurantes

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.foodforme.data.Fb_restaurantes
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class ShowRestaurantsViewModel: ViewModel(){

    val tipo = MutableLiveData<String>()

    private val _datos = MutableLiveData<List<Fb_restaurantes>>()
    val datos: LiveData<List<Fb_restaurantes>>
        get() = _datos


    init{
        //Filtra únicamente por tipo, hay que agregar el resto de filtrado
        val ref = FirebaseDatabase.getInstance().getReference("restaurantes").orderByChild("type").equalTo(tipo.value)
        ref.addValueEventListener(object:ValueEventListener{
            @SuppressLint("LongLogTag")
            override fun onDataChange(p0: DataSnapshot) {
                var list = ArrayList<Fb_restaurantes>()
                if (p0!!.exists()){
                    for(i in p0.children){
                        var restaurant = i.getValue(Fb_restaurantes::class.java)
                        if (restaurant != null) {
                            list.add(Fb_restaurantes(restaurant.id,restaurant.direction,restaurant.name,restaurant.phone,restaurant.rating,restaurant.type))

                        }
                    }
                    _datos.value = list
                }
            }
            override fun onCancelled(p0: DatabaseError) {
                println(p0.toException())
            }
        })


    }

}