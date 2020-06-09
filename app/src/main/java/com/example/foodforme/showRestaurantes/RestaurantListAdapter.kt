package com.example.foodforme.showRestaurantes

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.foodforme.data.Restaurant
import com.example.foodforme.databinding.RestaurantItemBinding

class RestaurantListAdapter(val clickListener: RestaurantListener): ListAdapter<Restaurant, RestaurantListAdapter.ViewHolder>(GuestListDiffCallback()) {


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item, clickListener)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    class ViewHolder private constructor(val binding: RestaurantItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Restaurant, clickListener: RestaurantListener){
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

class GuestListDiffCallback: DiffUtil.ItemCallback<Restaurant>() {
    override fun areItemsTheSame(oldItem: Restaurant, newItem: Restaurant): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: Restaurant, newItem: Restaurant): Boolean {
        return oldItem == newItem
    }
}

class RestaurantListener(val clickListener: (restaurante: Restaurant) -> Unit){
    fun onClick(restaurante: Restaurant) = clickListener(restaurante)
}
