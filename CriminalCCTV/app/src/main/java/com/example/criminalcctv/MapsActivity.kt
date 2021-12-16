package com.example.criminalcctv

import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.location.Address
import android.location.Geocoder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.core.graphics.drawable.toBitmap

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.example.criminalcctv.databinding.ActivityMapsBinding
import com.google.android.gms.maps.model.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MapsActivity : AppCompatActivity(), OnMapReadyCallback, GoogleMap.OnInfoWindowClickListener, GoogleMap.OnMarkerClickListener {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsBinding

    private lateinit var geocoder: Geocoder

    private lateinit var crimeData : ArrayList<CrimeTypeData>
    private lateinit var latlngList : ArrayList<LatLng>

    private var clickedPosition : LatLng? = null

    private var locationMarker : ArrayList<Marker?> = arrayListOf()
    private var cctvMarker : ArrayList<Marker?> = arrayListOf()

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
            locationMarker.add(
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
            )
        }

        mMap.setOnMarkerClickListener(this)
        mMap.setOnInfoWindowClickListener(this)
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

    /**
     * @Override
     * onInfoWindowClick(Marker)
     *
     * Marker 클릭 -> Snippet 클릭 시 수행되는 메소드
     *
     * 1. 현재 눌린 snippet의 position과 이전을 비교해서 같으면 아무것도 동작 x
     * 1-1. 다르면(다른 지역 마커를 클릭했으면 원래 있던 cctvMarker를 모두 제거
     * 2. progess ingress
     * 3. cctvMarker 표시
     */
    override fun onInfoWindowClick(marker: Marker) {
        Log.d("PSY", "OnInfoWindowClicked")
        Log.d("PSY", "clickedPosition : $clickedPosition")
        if (!marker.position.equals(clickedPosition)) {
            Log.d("PSY", "All CCTV marker will be removed")
            for (i in 0 until cctvMarker.size) {
                cctvMarker[i]?.remove()
            }
            cctvMarker.clear()
        }
        // 이제 맵에 cctvMarker는 없음. 새로 찾아서 그려야 함.
        Toast.makeText(this, "CCTV 데이터를 불러올 때까지 잠시만 기다려주세요.", Toast.LENGTH_LONG).show()
        val markerAddr : Address = geocoder.getFromLocationName(marker.title, 10)[0]
        // markerAddr : Address[addressLines=[0:"대한민국 서울특별시 강남구"],feature=강남구,admin=서울특별시,
        // sub-admin=null,locality=null,thoroughfare=null,postalCode=null,countryCode=KR,countryName=대한민국,
        // hasLatitude=true,latitude=37.5172363,hasLongitude=true,longitude=127.0473248,phone=null,url=null,extras=null]
        Log.d("PSY", "markerAddr : $markerAddr")

        try {
            // lv1List : (seoul, jeju, gangwon, ...) 중 한 리스트
            // lv2List : (seoul 중 원하는 결과를 줄 수 있는 리스트)
            var lv1List : ArrayList<String>? = DEFINES.classificate1(markerAddr.adminArea) // adminArea : 서울특별시
            var lv2List : ArrayList<String> = DEFINES.classificate2(markerAddr.featureName, lv1List!!) // feature : 강남구

            CoroutineScope(Dispatchers.Main).launch {
                withContext(CoroutineScope(Dispatchers.Default).coroutineContext) {
                    var cctvList : ArrayList<CCTVData> = HTTPTask.getCCTVdata(lv2List)

                    for (i in 0 until cctvList.size) {
                        Log.d("PSY", "cctv loading : $i / ${cctvList.size}")
                        runOnUiThread {
                            cctvMarker.add(
                                mMap.addMarker(
                                    MarkerOptions()
                                        .position(cctvList[i].position)
                                        .title(cctvList[i].location)
                                        .snippet(cctvList[i].info)
                                        .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_cctv))
                                )
                            )
                            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(LatLng(markerAddr.latitude, markerAddr.longitude), 13f))
                        }
                    }
                }
            }
        } catch (e : Exception) {
            e.printStackTrace()
        }
    }

    /**
     * @Override
     * onMarkerClick(Marker)
     *
     * 1. snippet 표시
     * 2. 현재 위치 기록
     * 3. clickedPosition 분기 선언
     */
    override fun onMarkerClick(marker : Marker): Boolean {
        Log.d("PSY", "OnMarkerClicked")
        marker.showInfoWindow()
        if (clickedPosition == null || clickedPosition != marker.position) {
            clickedPosition = marker.position
        }
        return true
    }
}