package com.example.foodforme.filterFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.foodforme.R
import com.example.foodforme.databinding.FragmentFilterBinding


class FilterFragment : Fragment() {
    private lateinit var binding: FragmentFilterBinding
    private lateinit var viewModel: FilterViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Muestro el Fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_filter, container, false)
        binding.lifecycleOwner = this


        // Creo mi viewmodel
        viewModel = ViewModelProvider(this).get(FilterViewModel::class.java)

        binding.button.setOnClickListener {
            view?.findNavController()?.navigate(R.id.action_filterFragment_to_showRestaurantsFragment)
        }

        return binding.root
    }
}