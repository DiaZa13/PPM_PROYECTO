package com.example.foodforme.user_preferences

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.foodforme.R

class userPreferencesFragment : Fragment() {

    companion object {
        fun newInstance() = userPreferencesFragment()
    }

    private lateinit var viewModel: UserPreferencesViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.user_preferences_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(UserPreferencesViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
