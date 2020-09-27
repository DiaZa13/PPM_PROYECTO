package com.example.foodforme.showOfertas

import androidx.lifecycle.ViewModel

class ShowOfertasViewModel : ViewModel(){
/*
    private val _datos = MutableLiveData<List<Oferta>>()
    val datos: LiveData<List<Oferta>>
        get() = _datos

    init {

        val ref = FirebaseDatabase.getInstance().getReference("promociones")
        ref.addValueEventListener(object: ValueEventListener {
            override fun onDataChange(p0: DataSnapshot) {
                var list = ArrayList<Oferta>()
                if (p0!!.exists()){
                    for(i in p0.children){
                        var oferta = i.getValue(Oferta::class.java)
                        if (oferta != null) {
                            list.add(Oferta(oferta.id,oferta.restaurante,oferta.menu,oferta.precio))

                        }
                    }
                    _datos.value = list
                }
            }
            override fun onCancelled(p0: DatabaseError) {
               Log.w("ShowOfertasViewModel",p0.toException())
            }
        })

    }*/
}