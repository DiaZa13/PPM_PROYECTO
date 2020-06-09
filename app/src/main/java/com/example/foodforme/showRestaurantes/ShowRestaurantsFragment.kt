package com.example.foodforme.showRestaurantes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.foodforme.R
import com.example.foodforme.databinding.FragmentShowRestaurantsBinding
// import com.google.firebase.database.*

class ShowRestaurantsFragment : Fragment() {
    private lateinit var binding: FragmentShowRestaurantsBinding
    private lateinit var viewModel: ShowRestaurantsViewModel
    // lateinit var ref:DatabaseReference

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Muestro el Fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_show_restaurants, container, false)
        binding.lifecycleOwner = this

        // Creo mi viewmodel
        viewModel = ViewModelProvider(this).get(ShowRestaurantsViewModel::class.java)

        // Para el recycler view
        val adapter = RestaurantListAdapter()
        binding.restaurantsRecycler.adapter = adapter
        adapter.submitList(viewModel.datos.value)

        // Para que se actuailce con la base de datos
        viewModel.datos.observe(viewLifecycleOwner, Observer {
            it.let { adapter.submitList(it) }
        })

        // Pues no corre esto pero no es por mi culpa, se toca la tarjeta, no el recyclerview.
        binding.restaurantsRecycler.setOnClickListener {
            view?.findNavController()?.navigate(R.id.action_showRestaurantsFragment_to_restaurantInfoFragment)
        }

        return binding.root
    }
}