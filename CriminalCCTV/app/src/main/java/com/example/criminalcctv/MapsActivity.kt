package com.example.criminalcctv

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.drawable.BitmapDrawable
import android.location.Geocoder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ProgressBar
import androidx.core.app.BundleCompat
import androidx.fragment.app.FragmentManager

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.example.criminalcctv.databinding.ActivityMapsBinding
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.BitmapDescriptorFactory.fromResource
import kotlin.concurrent.thread
import kotlin.concurrent.timer

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

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

        // default camera location is Seoul
        val seoulAddress = geocoder.getFromLocationName("서울시", 10)[0]
        val seoul = LatLng(seoulAddress.latitude, seoulAddress.longitude)
        mMap.addMarker(MarkerOptions().position(seoul)
            .title("서울시")
            .snippet("서울특별시")
        )
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(seoul, 15f))

        // 도시명과 도시-범죄 횟수 리스트 초기화
        var list = intent.getStringArrayListExtra("cityName")
        var cityList : ArrayList<String> = arrayListOf()
        for (i in 0 until list!!.size) {
            if (!list!![i].equals("기타도시") && !list!![i].equals("도시이외")) {
                cityList.add(list!![i])
            }
        }
        list.clear()
        list = intent.getStringArrayListExtra("cityCrime")
        var crimeList : ArrayList<String> = arrayListOf()
        for (i in 0 until list!!.size) {
            crimeList.add(list!![i])
        }

        // 도시-범죄 횟수 맵마커 표시
        for (i in 0 until cityList.size) {
            Log.d("PSY", "cityList : $i -> ${cityList[i]}")
            try {
                val locationInfo = geocoder.getFromLocationName(cityList[i], 1)[0]
                val location = LatLng(locationInfo.latitude, locationInfo.longitude)
                mMap.addMarker(MarkerOptions().position(location)
                    .title(cityList[i])

                    .snippet("숫자놀이잼")
                )
            } catch (e: Exception) {
                continue
            }
        }

    }
}