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
import com.example.foodforme.databinding.FragmentFilterBinding
import com.example.foodforme.databinding.FragmentRateRestaurantBinding
import com.example.foodforme.filterFragment.FilterViewModel

class RateRestaurantFragment : Fragment() {
    private lateinit var binding: FragmentRateRestaurantBinding
    private lateinit var viewModel: FilterViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        // Muestro el Fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_rate_restaurant, container, false)
        binding.lifecycleOwner = this

        binding.button.setOnClickListener{
            findNavController().navigateUp()
        }

        return binding.root
    }
}