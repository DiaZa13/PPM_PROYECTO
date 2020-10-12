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
import com.google.firebase.auth.FirebaseAuth


class FilterFragment : Fragment() {
    private lateinit var binding: FragmentFilterBinding
    private lateinit var viewModel: FilterViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Muestro el Fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_filter, container, false)
        binding.lifecycleOwner = this


        binding.btnTimer.setOnClickListener {
            view?.findNavController()?.navigate(R.id.action_filterFragment_to_timerFragment)
        }

        binding.btnHistory.setOnClickListener {
            view?.findNavController()?.navigate(R.id.action_filterFragment_to_showOfertasFragment)
        }

        binding.btnTips.setOnClickListener {
            view?.findNavController()?.navigate(R.id.action_filterFragment_to_showRestaurantsFragment)
        }

        binding.btnLogout.setOnClickListener{
            FirebaseAuth.getInstance().signOut()
            view?.findNavController()?.navigate(R.id.action_filterFragment_to_loginFragment)

        }
        // Creo mi viewmodel
        viewModel = ViewModelProvider(this).get(FilterViewModel::class.java)

        return binding.root
    }
}