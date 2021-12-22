package com.example.recreationmanager.choicehelper

import android.content.Intent
import android.location.Address
import android.location.Geocoder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.recreationmanager.R

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.example.recreationmanager.databinding.ActivityMapsBinding
import com.example.recreationmanager.schedule.AddScheduleActivity
import com.google.android.gms.maps.model.Marker
import java.lang.Exception

class MapsActivity : AppCompatActivity(), OnMapReadyCallback, GoogleMap.OnMapLongClickListener,
    GoogleMap.OnInfoWindowClickListener {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsBinding

    private lateinit var geocoder: Geocoder

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        geocoder = Geocoder(this)

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
        val chuncheonAddr = geocoder.getFromLocationName("춘천", 10)[0]
        val chuncheon = LatLng(chuncheonAddr.latitude, chuncheonAddr.longitude)
        mMap.addMarker(
            MarkerOptions()
                .position(chuncheon)
                .title("춘천")
                .snippet("태초마을")
        )
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(chuncheon, 10f))

        mMap.setOnMapLongClickListener(this)
        mMap.setOnInfoWindowClickListener(this)
    }

    override fun onMapLongClick(position: LatLng) {
        mMap.clear()
        val currentAddr : Address = geocoder.getFromLocation(position.latitude, position.longitude, 10)[0]
        Log.d("PSY", "currentAddr : $currentAddr")
//        addressLines=[0:"대한민국 강원도 춘천시 효자2동 192-8"]
//        feature=１９２−８
//        admin=강원도
//        locality=춘천시
//        thoroughfare=효자2동
        mMap.addMarker(
            MarkerOptions()
                .position(position)
                .title(currentAddr.locality)
                .snippet(currentAddr.thoroughfare)
        )
    }

    override fun onInfoWindowClick(marker: Marker) {
        try {
            val mIntent = intent.getStringExtra("fromWhere")
            val address = geocoder.getFromLocation(marker.position.latitude, marker.position.longitude, 10)[0].getAddressLine(0)
            when (mIntent) {
                "main" -> {
                    val intent = Intent(applicationContext, AddScheduleActivity::class.java)
                    intent.putExtra("locationData", address)
                    startActivity(intent)
                }
                "addSchedule" -> {
                    val intent = Intent()
                    intent.putExtra("locationData", address)
                    setResult(RESULT_OK, intent)
                    finish()
                }
            }
        } catch (e : Exception) {
            e.printStackTrace()
        }
    }
}