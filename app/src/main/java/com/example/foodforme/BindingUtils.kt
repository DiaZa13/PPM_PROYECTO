package com.example.foodforme

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.example.foodforme.data.Tips

@BindingAdapter("setImage")
fun ImageView.setImage(item: Tips){
    item?.let{
        setImageResource(when(item.name){
            "Duchar" -> R.drawable.tip_ducha
            "Cocinar" -> R.drawable.tip_cocinar
            "Afeitar" -> R.drawable.tip_afeitar
            "Cepillar" -> R.drawable.tip_cepillar
            else -> R.mipmap.urda_blogo
        })
    }
}