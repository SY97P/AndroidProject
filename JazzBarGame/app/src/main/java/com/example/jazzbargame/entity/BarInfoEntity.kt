package com.example.jazzbargame.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class BarInfoEntity(
    @PrimaryKey
    val barId : Int,
    val barImage : Int,
    val barName : String,
    var profit : String,
    val goal : String,
    val date : String
) {}

