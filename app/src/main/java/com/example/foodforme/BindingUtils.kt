package com.example.foodforme

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.example.foodforme.data.Fb_restaurantes

@BindingAdapter("setImage")
fun ImageView.setImage(item: Fb_restaurantes){
    item?.let{
        setImageResource(when(item.name){
            "Pollo Campero" -> R.drawable.pollo_campero
            "Burger King" -> R.drawable.burger_king
            "Pizza Hut" -> R.drawable.macdonald
            "Taco Bell" -> R.drawable.taco_bell
            else -> R.mipmap.logo_white
        })
    }
}