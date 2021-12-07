package com.example.addresslatlngconvertor

import android.location.Geocoder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.example.addresslatlngconvertor.databinding.ActivityMapsBinding
import com.google.android.gms.maps.model.Marker

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsBinding

    private lateinit var geocoder: Geocoder

    private var LAT : Double = 0.0
    private var LNG : Double = 0.0
    private var ADDR : String? = null
    private var INPUT : String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        geocoder = Geocoder(this)

        // 초기값은 금천구
        LAT = intent.getDoubleExtra("lat", 37.4769739)
        LNG = intent.getDoubleExtra("lng", 126.88231279999998)
        ADDR = intent.getStringExtra("address")
        INPUT = intent.getStringExtra("input")

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
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
        val location = LatLng(LAT, LNG)
        val marker = mMap.addMarker(MarkerOptions().position(location)
            .title(ADDR)
            .snippet("LAT : ${String.format("%.2f", LAT)} / LNG : ${String.format("%.2f", LNG)}")
        )
        marker?.showInfoWindow()
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(location, 17f))

        mMap.setOnMapLongClickListener(object : GoogleMap.OnMapLongClickListener {
            override fun onMapLongClick(position : LatLng) {
                val mOptions = MarkerOptions()
                val lat : Double = position.latitude
                val lng : Double = position.longitude
                val address : String = geocoder.getFromLocation(lat, lng, 10).toString()
                mOptions.title(address)
                mOptions.snippet("Lat : ${String.format("%.2f", lat)} / Lng : ${String.format("%.2f", lng)}")
                mOptions.position(LatLng(lat, lng))
                mMap.addMarker(mOptions)
            }
        })
    }
}