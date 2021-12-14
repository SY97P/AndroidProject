package com.example.criminalcctv

import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.location.Geocoder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.graphics.drawable.toBitmap

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.example.criminalcctv.databinding.ActivityMapsBinding
import com.google.android.gms.maps.model.*

class MapsActivity : AppCompatActivity(), OnMapReadyCallback, GoogleMap.OnMarkerClickListener {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsBinding

    private lateinit var geocoder: Geocoder

    private lateinit var crimeData : ArrayList<CrimeTypeData>
    private lateinit var latlngList : ArrayList<LatLng>

    private var clickedPosition : LatLng? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        geocoder = Geocoder(this)

        // load intent lists
        crimeData = composeCrimeData()
        latlngList = convertToLatLng()

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    private fun convertToLatLng(): ArrayList<LatLng> {
        var result : ArrayList<LatLng> = arrayListOf()
        var list = intent.getStringArrayListExtra("latlngList")
        Log.d("PSY", "size : ${list!!.size}")
        for (i in 0 until list!!.size) {
            val temp = list!![i].replace("lat/lng: ", "").replace(")", "").replace("(", "").split(",")
            Log.d("PSY", "temp : $temp")
            //Log.d("PSY", "temp[0] : ${temp[0]}, temp[1] : ${temp[1]}")
            result.add(LatLng(temp[0].toDouble(), temp[1].toDouble()))
        }
        return result
    }

    private fun composeCrimeData(): ArrayList<CrimeTypeData> {
        var result : ArrayList<CrimeTypeData> = arrayListOf()
        Log.d("PSY", "loadingCrimeList : ${intent.getStringArrayListExtra("loadingCrimeList")}")
        var size = intent.getStringArrayListExtra("loadingCrimeList")!!.size
        for (i in 0 until size) {
            result.add(CrimeTypeData(
                intent.getStringArrayListExtra("loadingCrimeList")!!.get(i).toString(),
                intent.getStringArrayListExtra("loadingCityList")!!.get(i).toString(),
                intent.getStringArrayListExtra("loadingCountList")!!.get(i).toInt()
            ))
        }
        return result
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Add a marker in Sydney and move the camera
        val seoulAddress = geocoder.getFromLocationName("서울", 10).get(0)
        val seoul = LatLng(seoulAddress.latitude, seoulAddress.longitude)
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(seoul, 10f))

        for (i in 0 until crimeData.size) {
            mMap.addMarker(MarkerOptions()
                .position(latlngList[i])
                .title(crimeData[i].city)
                .snippet("[${crimeData[i].crime}] 발생횟수 : ${crimeData[i].count.toString()}")
                .icon(
                    when {
                        crimeData[i].count > isDanger() -> {
                            BitmapDescriptorFactory.fromResource(R.drawable.ic_danger)
                        }
                        crimeData[i].count < isSafe() -> {
                            BitmapDescriptorFactory.fromResource(R.drawable.ic_safe)
                        }
                        else -> {
                            BitmapDescriptorFactory.fromResource(R.drawable.ic_dot)
                        }
                    }
                )
            )
        }

        mMap.setOnMarkerClickListener (object : GoogleMap.OnMarkerClickListener {
            override fun onMarkerClick(marker : Marker): Boolean {
                if (clickedPosition == null) {
                    clickedPosition = marker.position
                } else {
                    if (clickedPosition!!.equals(marker.position)) {
                        // 다른 마커 지우고 지역 CCTV 마커 생성
                        mMap
                    }
                }
                return true
            }
        })
    }

    private fun isDanger() : Int {
        var countList : ArrayList<Int> = arrayListOf()
        for (i in 0 until crimeData.size) {
            countList.add(crimeData[i].count)
        }
        countList.sortByDescending { it }
        if (countList[4] * 2 < countList[3]) {
            return countList[3]
        }
        return countList[4]
    }

    private fun isSafe() : Int {
        var sum = 0
        for (i in 0 until crimeData.size){
            sum += crimeData[i].count
        }
        sum /= crimeData.size
        return (sum*0.25).toInt()
    }
}