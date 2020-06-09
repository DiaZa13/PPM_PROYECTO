package com.example.foodforme.showRestaurantes

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.foodforme.data.Fb_restaurantes
import com.example.foodforme.databinding.RestaurantItemBinding

class RestaurantListAdapter(val clickListener: RestaurantListener): ListAdapter<Fb_restaurantes, RestaurantListAdapter.ViewHolder>(GuestListDiffCallback()) {


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item, clickListener)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    class ViewHolder private constructor(val binding: RestaurantItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Fb_restaurantes, clickListener: RestaurantListener){
            binding.restaurant = item
            binding.clickListener = clickListener
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = RestaurantItemBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }
}

class GuestListDiffCallback: DiffUtil.ItemCallback<Fb_restaurantes>() {
    override fun areItemsTheSame(oldItem: Fb_restaurantes, newItem: Fb_restaurantes): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: Fb_restaurantes, newItem: Fb_restaurantes): Boolean {
        return oldItem.equals(newItem)
    }
}

class RestaurantListener(val clickListener: (restaurante: Fb_restaurantes) -> Unit){
    fun onClick(restaurante: Fb_restaurantes) = clickListener(restaurante)
}
