package com.example.foodforme.database;

import androidx.room.Entity;
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity(tableName = "restaurant_table")
data class Restaurant(
    @PrimaryKey(autoGenerate = true)  var Id: Int = 0,
    @NotNull val name: String,
    @NotNull val phone: String,
    @NotNull val direccion: String,
    val logo: String
)
