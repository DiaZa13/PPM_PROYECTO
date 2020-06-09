package com.example.foodforme.data

import java.io.Serializable

// De seguro le vamos a agregar más cosas pero por ahora eso está bien
data class Restaurant(
    val name: String,
    val phone: String,
    val direction: String,
    val rating: Float,
    val tipo: String
): Serializable