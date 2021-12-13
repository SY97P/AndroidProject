package com.example.criminalcctv

import android.location.Geocoder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.example.criminalcctv.databinding.ActivityMapsBinding

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsBinding

    private lateinit var geocoder: Geocoder

    private lateinit var cityData : ArrayList<CrimeTypeData>
    private lateinit var latlngList : ArrayList<LatLng>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        geocoder = Geocoder(this)

        cityData = intent.getParcelableArrayListExtra<CrimeTypeData>("cityData") as ArrayList<CrimeTypeData>
        latlngList = intent.getParcelableArrayListExtra<LatLng>()

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
        val seoulAddress = geocoder.getFromLocationName("서울", 10).get(0)
        val seoul = LatLng(seoulAddress.latitude, seoulAddress.longitude)
        mMap.addMarker(MarkerOptions().position(seoul)
            .title("서울시")
        )
        mMap.moveCamera(CameraUpdateFactory.newLatLng(seoul))

        for (i in 0 until cityData.size) {
            mMap.addMarker(MarkerOptions()
                .position(latlngList[i])
                .title(cityData[i].city)
                .snippet(cityData[i].count.toString())
            )
        }
    }
}