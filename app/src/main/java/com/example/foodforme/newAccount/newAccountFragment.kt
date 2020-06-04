package com.example.foodforme.newAccount

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider


import com.example.foodforme.R
import com.example.foodforme.database.UserDatabase
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

        binding.btnNewaccount.setOnClickListener {
            val name = binding.txtName.toString()
            val user = binding.txtUser.toString()
            val email = binding.txtEmail.toString()
            val password = binding.txtPassword.toString()
            if (name == "" || user == "" || email == "" || password == "") {
                Toast.makeText(activity, "Por favor llene todos los campos proporcionados", Toast.LENGTH_SHORT).show()
            } else {
                viewModel.insertGuest()
            }
        }

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val application = requireNotNull(this.activity).application
        val dataSource = UserDatabase.getInstance(application).UserDatabaseDao
        viewModelFactory = NewAccountViewModelFactory(dataSource)
        viewModel = ViewModelProvider(this, viewModelFactory).get(NewAccountViewModel::class.java)

        binding.viewModel = viewModel

    }

}
