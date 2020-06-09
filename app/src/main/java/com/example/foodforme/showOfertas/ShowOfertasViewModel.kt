package com.example.foodforme.showOfertas

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.foodforme.data.Oferta
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class ShowOfertasViewModel : ViewModel(){

    private val _datos = MutableLiveData<List<Oferta>>()
    val datos: LiveData<List<Oferta>>
        get() = _datos

    init {

        val ref = FirebaseDatabase.getInstance().getReference("promociones")
        ref.addValueEventListener(object: ValueEventListener {
            override fun onDataChange(p0: DataSnapshot) {
                if (p0!!.exists()){
                    for(i in p0.children){
                        var oferta = i.getValue(Oferta::class.java)
                        if (oferta != null) {
                            _datos.value = mutableListOf(
                                Oferta(oferta.id,oferta.restaurante,oferta.menu,oferta.precio)
                            )

                        }
                    }
                }
            }
            override fun onCancelled(p0: DatabaseError) {
               Log.w("ShowOfertasViewModel",p0.toException())
            }
        })

    }
}