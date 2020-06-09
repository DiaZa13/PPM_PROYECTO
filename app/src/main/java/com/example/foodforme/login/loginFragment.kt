package com.example.foodforme.login


import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.foodforme.R
import com.example.foodforme.databinding.LoginFragmentBinding
import com.example.foodforme.databinding.SnackbarErrorBinding
import com.google.android.gms.auth.api.Auth
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.Api
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.common.api.GoogleApiClient
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import kotlinx.android.synthetic.main.login_fragment.*


class loginFragment : Fragment() {


    private lateinit var viewModel: LoginViewModel
    private lateinit var viewModelFactory: LoginViewModelFactory
    private lateinit var binding: LoginFragmentBinding
    private val Google = 100


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
            else{
                viewModel.logIn()
            }

        }

        binding.btnStart.setOnClickListener {
            val user = binding.txtUser.text.toString()
            val password = binding.txtPassword.text.toString()

            if (user.isEmpty() || password.isEmpty())
                makeWarning("Debes llenar todos los campos")
            else{
                viewModel.logIn()
            }

            btnGoogle.setOnClickListener {
                googleLogin()

            }
        }
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val application = requireNotNull(this.activity).application
        viewModelFactory = LoginViewModelFactory()
        viewModel = ViewModelProvider(this, viewModelFactory).get(LoginViewModel::class.java)
        // TODO: Use the ViewModel

        binding.viewModel = viewModel

        viewModel.isUser.observe(viewLifecycleOwner, Observer {
            if (it) {
                view?.findNavController()?.navigate(R.id.action_loginFragment_to_filterFragment)

            }
            else{
                makeWarning("Usuario y/o contraseña incorrecto")
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

    fun googleLogin(){
        val googleConf = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()

        val googleClient = GoogleSignIn.getClient(this.requireActivity(),googleConf)

        startActivityForResult(googleClient.signInIntent,Google)
    }



}

