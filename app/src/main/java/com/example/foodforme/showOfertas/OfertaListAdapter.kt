package com.example.foodforme.showOfertas

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.foodforme.data.Oferta
import com.example.foodforme.databinding.OfertaItemBinding

class OfertaListAdapter: ListAdapter<Oferta, OfertaListAdapter.ViewHolder>(GuestListDiffCallback()) {


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    class ViewHolder private constructor(val binding: OfertaItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Oferta){
            binding.oferta = item
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = OfertaItemBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }
}

class GuestListDiffCallback: DiffUtil.ItemCallback<Oferta>() {
    override fun areItemsTheSame(oldItem: Oferta, newItem: Oferta): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Oferta, newItem: Oferta): Boolean {
        return oldItem == newItem
    }
}