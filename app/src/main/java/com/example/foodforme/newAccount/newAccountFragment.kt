package com.example.foodforme.newAccount

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider

import com.example.foodforme.R
import com.example.foodforme.databinding.NewAccountFragmentBinding

class newAccountFragment : Fragment() {

    companion object {
        fun newInstance() = newAccountFragment()
    }

    private lateinit var viewModel: NewAccountViewModel
    private lateinit var viewModelFactory: NewAccountViewModelFactory
    private lateinit var binding: NewAccountFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.new_account_fragment, container, false)

        return binding.root    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(NewAccountViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
