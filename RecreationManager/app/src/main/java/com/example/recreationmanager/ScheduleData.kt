package com.example.recreationmanager

import android.location.Address

data class ScheduleData (
    val calendarTitle : String,
    val startTime : String,
    val endTime : String,
    // a : 0, b : 1, c : 2
    val priority : Int,
    val location : Address,
    val note : String
        ){
}