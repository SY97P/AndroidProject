package com.example.criminalcctv.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CityNameEntity(
    @PrimaryKey
    val cityId : Int,
    val cityName : String
) {
}