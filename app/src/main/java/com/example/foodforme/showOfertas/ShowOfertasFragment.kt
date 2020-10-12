package com.example.foodforme.showOfertas

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.foodforme.R
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.foodforme.databinding.FragmentShowOfertasBinding

class ShowOfertasFragment : Fragment() {
    private lateinit var binding: FragmentShowOfertasBinding
    private lateinit var viewModel: ShowOfertasViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Muestro el Fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_show_ofertas, container, false)
        binding.lifecycleOwner = this

        // Creo mi viewmodel
        viewModel = ViewModelProvider(this).get(ShowOfertasViewModel::class.java)

        // Para el recycler view
        val adapter = OfertaListAdapter()
        binding.restaurantsRecycler.adapter = adapter
        adapter.submitList(viewModel.datos.value)
        binding.restaurantsRecycler.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
        viewModel.datos.observe(viewLifecycleOwner, Observer {
            it.let { adapter.submitList(it) }
        })

        return binding.root
    }
}