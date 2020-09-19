package com.example.foodforme.showRestaurantes

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.foodforme.data.Tips
import com.example.foodforme.databinding.RestaurantItemBinding

class RestaurantListAdapter(val clickListener: RestaurantListener): ListAdapter<Tips, RestaurantListAdapter.ViewHolder>(GuestListDiffCallback()) {


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item, clickListener)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    class ViewHolder private constructor(val binding: RestaurantItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Tips, clickListener: RestaurantListener){
            binding.tip = item
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

class GuestListDiffCallback: DiffUtil.ItemCallback<Tips>() {
    override fun areItemsTheSame(oldItem: Tips, newItem: Tips): Boolean {
        return oldItem.tittle == newItem.tittle
    }

    override fun areContentsTheSame(oldItem: Tips, newItem: Tips): Boolean {
        return oldItem.equals(newItem)
    }
}

class RestaurantListener(val clickListener: (tip: Tips) -> Unit){
    fun onClick(tip: Tips) = clickListener(tip)
}
