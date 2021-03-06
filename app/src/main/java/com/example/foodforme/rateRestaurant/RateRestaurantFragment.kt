package com.example.foodforme.rateRestaurant

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.foodforme.R
import com.example.foodforme.databinding.FragmentRateRestaurantBinding

class RateRestaurantFragment : Fragment() {
    private lateinit var binding: FragmentRateRestaurantBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        // Muestra el fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_rate_restaurant, container, false)
        binding.lifecycleOwner = this

        /*
        //Extracción de datos para enviar a firebase
        val rate = binding.ratingBar.rating.toInt()
        val price: Int

        val radioG = binding.radioGroup

        if(binding.price1.isChecked){
            price = 1
        }else if(binding.price2.isChecked){
            price = 2
        }else
            price = 3


        //Envío de datos a firebase

        // Ahora sí Diana, seguía dormido
        val restaurante: Fb_restaurantes = arguments?.getSerializable("Restaurant") as Fb_restaurantes
        val newRate = (restaurante.rating + rate)/2
        val ref = FirebaseDatabase.getInstance().reference
        val newRestaurant = update_restaurant(restaurante.direction,restaurante.name,restaurante.phone,newRate,restaurante.type,price)
        Log.i("RateRestaurantFragment",restaurante.id)
        binding.button.setOnClickListener{
            ref.child("restaurantes").child(restaurante.name).setValue(newRestaurant)

            findNavController().navigateUp()

        }*/

        return binding.root
    }


}