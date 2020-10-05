package com.example.foodforme.data

import java.time.LocalDateTime

data class User(
    val id: String = "",
    val date: LocalDateTime? = null,
    val intake: Double? = 0.0
)