package com.example.foodforme.data

import java.io.Serializable

// De seguro le vamos a agregar más cosas pero por ahora eso está bien
data class Restaurant(
    val id: String,
    val direction: String,
    val name: String,
    val rating: Int,
    val phone: String,
    val type: String
): Serializable