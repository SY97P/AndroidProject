package com.example.criminalcctv

import com.google.android.gms.maps.model.LatLng

/**
 * @param
 * position 위경도좌표
 * location 도로명주소
 * info     전화번호
 */
data class CCTVData (
    val position : LatLng,
    val location : String,
    val info : String
        ) {
}