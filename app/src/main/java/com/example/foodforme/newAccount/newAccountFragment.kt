package com.example.foodforme.newAccount

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
import com.example.foodforme.databinding.NewAccountFragmentBinding
import com.example.foodforme.databinding.SnackbarErrorBinding
import com.google.android.material.snackbar.Snackbar

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

        binding.btnNewaccount.setOnClickListener {
            val user = binding.txtUser.toString()
            val password = binding.txtPassword.toString()
            if (user == "" || password == "") {
                makeWarning("Debes llenar todos los campos")
            } else {
                viewModel.newAccount()
            }
        }

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(NewAccountViewModel::class.java)

        binding.viewModel = viewModel

        viewModel.newUser.observe(viewLifecycleOwner, Observer {
            if (it) {
                view?.findNavController()?.navigate(R.id.action_newAccountFragment_to_loginFragment)
            }else{
                makeWarning("La cuenta ya está en uso")
            }
        })

    }

    // Adaptado de https://stackoverflow.com/questions/32453946/how-to-customize-snackbars-layout/33441214#33441214
    private fun makeWarning(warning: String){
        val snackbar = Snackbar.make(binding.root, "", Snackbar.LENGTH_SHORT)

        (snackbar.view as Snackbar.SnackbarLayout).apply {
            findViewById<View>(R.id.snackbar_text).visibility = View.INVISIBLE
            findViewById<View>(R.id.snackbar_action).visibility = View.INVISIBLE

            val snackbarBinding = DataBindingUtil.inflate<SnackbarErrorBinding>(
                LayoutInflater.from(this.context),
                R.layout.snackbar_error,
                binding.root as ViewGroup,
                false
            )
            snackbarBinding.warningText.text = warning
            setPadding(0, 0, 0, 0)
            addView(snackbarBinding.root, 0)

        }
        snackbar.setDuration(1500).show()
    }

}
