package com.example.foodforme.login

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController

import com.example.foodforme.R
import com.example.foodforme.database.UserDatabase
import com.example.foodforme.databinding.LoginFragmentBinding
import com.example.foodforme.databinding.SnackbarErrorBinding
import com.example.foodforme.newAccount.NewAccountViewModel
import com.example.foodforme.newAccount.NewAccountViewModelFactory
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.snackbar.SnackbarContentLayout

class loginFragment : Fragment() {
    private lateinit var viewModel: LoginViewModel
    private lateinit var viewModelFactory: LoginViewModelFactory
    private lateinit var binding: LoginFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.login_fragment, container, false)

        binding.txtNewaccount.setOnClickListener {
            view?.findNavController()?.navigate(R.id.action_loginFragment_to_newAccountFragment)
        }

        binding.btnStart.setOnClickListener {
            val user = binding.txtUser.text.toString()
            val password = binding.txtPassword.text.toString()

            if (user.isEmpty() || password.isEmpty())
                makeWarning("Debes llenar todos los campos")
            else
                makeWarning("Cannot Log In")
            /*viewModel.verifiedUser(userInput)
            viewModel.isUser.observe(viewLifecycleOwner, Observer {
                if (it) {
                    view?.findNavController()?.navigate(R.id.action_loginFragment_to_userPreferencesFragment)
                }
                else{
                    Toast.makeText(activity, "Usuario y/o contraseña incorrecto", Toast.LENGTH_SHORT).show()
                }
            })*/
        }
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val application = requireNotNull(this.activity).application
        val dataSource = UserDatabase.getInstance(application).UserDatabaseDao
        viewModelFactory = LoginViewModelFactory(dataSource)
        viewModel = ViewModelProvider(this, viewModelFactory).get(LoginViewModel::class.java)
        // TODO: Use the ViewModel

        binding.viewModel = viewModel
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

