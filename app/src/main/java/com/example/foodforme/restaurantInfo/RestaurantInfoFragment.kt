package com.example.foodforme.restaurantInfo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.foodforme.R
import com.example.foodforme.databinding.FragmentRestaurantInfoBinding


class RestaurantInfoFragment : Fragment() {
    private lateinit var binding: FragmentRestaurantInfoBinding
    private lateinit var viewModel: RestaurantInfoViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        // Muestro el Fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_restaurant_info, container, false)
        binding.lifecycleOwner = this

        viewModel = ViewModelProvider(this).get(RestaurantInfoViewModel::class.java)
        binding.viewModel = viewModel

        binding.rateButton.setOnClickListener {
            view?.findNavController()?.navigate(R.id.action_restaurantInfoFragment_to_rateRestaurantFragment)
        }

        return binding.root
    }
}