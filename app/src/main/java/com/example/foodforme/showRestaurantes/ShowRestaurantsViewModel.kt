package com.example.foodforme.showRestaurantes

import android.annotation.SuppressLint
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.foodforme.data.Tips
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class ShowRestaurantsViewModel: ViewModel(){

    private val _datos = MutableLiveData<List<Tips>>()
    val datos: LiveData<List<Tips>>
        get() = _datos


    init{
        //Filtra únicamente por tipo, hay que agregar el resto de filtrado
        val ref = FirebaseDatabase.getInstance().getReference("restaurantes")//Cambiar el path a la nueva base de datos
        ref.addValueEventListener(object:ValueEventListener{
            @SuppressLint("LongLogTag")
            override fun onDataChange(p0: DataSnapshot) {
                var list = ArrayList<Tips>()
                if (p0!!.exists()){
                    for(i in p0.children){
                        var tip = i.getValue(Tips::class.java)
                        if (tip != null) {
                            list.add(Tips(tip.tittle,tip.description,tip.reduction))

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