package com.example.foodforme

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.foodforme.databinding.FragmentAboutBinding
import com.example.foodforme.databinding.LoginFragmentBinding

/**
 * A simple [Fragment] subclass.
 */
class AboutFragment : Fragment() {

    private lateinit var binding: FragmentAboutBinding

    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_about, container, false)
        binding.txtNewaccount.setOnClickListener {
            view?.findNavController()?.navigate(R.id.action_aboutFragment_to_newAccountFragment2)
        }
        // Inflate the layout for this fragment
        return binding.root
    }

}
