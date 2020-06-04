package com.example.foodforme.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity(tableName = "user_table")
data class User(
    @PrimaryKey(autoGenerate = true)  var Id: Int = 0,
    @NotNull val name: String,
    @NotNull val user: String,
    @NotNull val email: String,
    @NotNull var password: String
)