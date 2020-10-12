package com.example.foodforme.showOfertas

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.foodforme.data.User
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class ShowOfertasViewModel : ViewModel(){

    private val _datos = MutableLiveData<List<User>>()
    val datos: LiveData<List<User>>
        get() = _datos

    init {

        val ref = FirebaseDatabase.getInstance().getReference("users/" + FirebaseAuth.getInstance().currentUser!!.uid)
        ref.addValueEventListener(object: ValueEventListener {
            override fun onDataChange(p0: DataSnapshot) {
                var list = ArrayList<User>()
                if (p0!!.exists()){
                    for(i in p0.children){
                        var user = i.getValue(User::class.java)
                        if (user != null) {
                            list.add(User(user.date,user.intake))

                        }
                    }
                    _datos.value = list
                }
            }
            override fun onCancelled(p0: DatabaseError) {
               Log.w("ShowOfertasViewModel",p0.toException())
            }
        })

    }
}