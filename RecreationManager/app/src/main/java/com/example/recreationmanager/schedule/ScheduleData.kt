package com.example.recreationmanager.schedule

import android.location.Address

data class ScheduleData (
    val calendarTitle : String,
    val startTime : String,
    val endTime : String,
    val priority : String,
    val location : String,
    val note : String
        ){
}