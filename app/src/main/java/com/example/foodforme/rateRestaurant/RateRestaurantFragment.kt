package com.example.foodforme.rateRestaurant

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.foodforme.R
import com.example.foodforme.data.Fb_restaurantes
import com.example.foodforme.data.update_restaurant
import com.example.foodforme.databinding.FragmentFilterBinding
import com.example.foodforme.databinding.FragmentRateRestaurantBinding
import com.example.foodforme.filterFragment.FilterViewModel
import com.google.firebase.database.FirebaseDatabase

class RateRestaurantFragment : Fragment() {
    private lateinit var binding: FragmentRateRestaurantBinding
    private lateinit var viewModel: FilterViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        // Muestro el Fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_rate_restaurant, container, false)
        binding.lifecycleOwner = this

        val rate = binding.ratingBar.rating.toInt()
        val price: Int

        val radioG = binding.radioGroup

        if(binding.price1.isChecked){
            price = 1
        }else if(binding.price2.isChecked){
            price = 2
        }else
            price = 3



        // Ahora sí Diana, seguía dormido
        val restaurante: Fb_restaurantes = arguments?.getSerializable("Restaurant") as Fb_restaurantes
        val newRate = (restaurante.rating + rate)/2
        val ref = FirebaseDatabase.getInstance().reference
        val newRestaurant = update_restaurant(restaurante.direction,restaurante.name,restaurante.phone,newRate,restaurante.type,price)
        Log.i("RateRestaurantFragment",restaurante.id)
        binding.button.setOnClickListener{
            ref.child("restaurantes").child(restaurante.name).setValue(newRestaurant)

            findNavController().navigateUp()

        }

        return binding.root
    }
}