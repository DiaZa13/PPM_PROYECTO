package com.example.foodforme.rateRestaurant

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.foodforme.R
import com.example.foodforme.data.Fb_restaurantes
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

        // Ahora sí Diana, seguía dormido
        val restaurante: Fb_restaurantes = arguments?.getSerializable("Restaurant") as Fb_restaurantes

        var newRate = (restaurante.rating) + (rate/3) - 1
        if(newRate < 0){
            newRate = 0
        }else if(newRate > 5){
            newRate = 5
        }
        val ref = FirebaseDatabase.getInstance().getReference("restaurantes")

        binding.button.setOnClickListener{
            ref.child(restaurante.id).child("rating").setValue(newRate)
            findNavController().navigateUp()

        }

        return binding.root
    }
}