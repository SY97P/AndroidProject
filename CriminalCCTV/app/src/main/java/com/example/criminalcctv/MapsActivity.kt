package com.example.criminalcctv

import android.content.res.AssetManager
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.location.Address
import android.location.Geocoder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.core.graphics.alpha
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
import java.lang.Exception
import kotlin.concurrent.thread

class MapsActivity : AppCompatActivity(), OnMapReadyCallback, GoogleMap.OnInfoWindowClickListener, GoogleMap.OnMarkerClickListener {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsBinding

    private lateinit var geocoder: Geocoder

    private lateinit var crimeData : ArrayList<CrimeTypeData>
    private lateinit var latlngList : ArrayList<LatLng>

    private var clickedPosition : LatLng? = null

    private var locationMarker : ArrayList<Marker?> = arrayListOf()
    private var cctvMarker : ArrayList<Marker?> = arrayListOf()

    lateinit var assetMananger : AssetManager

    private var jsonIndexing = mapOf<String, String>(
        "강남구청" to "gangnam",
        "강북경찰서" to "ganbukPolice",
        "강북구청" to "ganbuk",
        "강서구" to "ganseo",
        "관악구청" to "gwanak",
        "광진구청" to "gwanjin",
        "구로구청" to "guro",
        "금천구청" to "guemcheon",
        "노원구청" to "nowon",
        "동대문구청" to "dongdaemun",
        "동작구청" to "dongjak",
        "마포구청" to "mapo",
        "서대문구청" to "seodaemun",
        "서초구청" to "seocho",
        "성동구청" to "seondong",
        "성북구청" to "seongbuk",
        "송파구청" to "songpa",
        "양천구청" to "yangcheon",
        "영등포구청" to "yeongduengpo",
        "용산구청" to "yongsan",
        "은평구청" to "eunpyeong",
        "종로구청" to "jongro",
        "중구청" to "junggu",
        "중랑구청" to "jungrang"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        geocoder = Geocoder(this)

        assetMananger = this.resources.assets

        this.supportActionBar!!.setTitle("서울특별시")

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
//        Log.d("PSY", "size : ${list!!.size}")
        for (i in 0 until list!!.size) {
            val temp = list!![i].replace("lat/lng: ", "").replace(")", "").replace("(", "").split(",")
            // Log.d("PSY", "temp : $temp")
            // Log.d("PSY", "temp[0] : ${temp[0]}, temp[1] : ${temp[1]}")
            result.add(LatLng(temp[0].toDouble(), temp[1].toDouble()))
        }
        return result
    }

    private fun composeCrimeData(): ArrayList<CrimeTypeData> {
        var result : ArrayList<CrimeTypeData> = arrayListOf()
//        Log.d("PSY", "loadingCrimeList : ${intent.getStringArrayListExtra("loadingCrimeList")}")
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

//        val backgroundPolygon : Polygon = mMap.addPolygon(
//            PolygonOptions()
//                .clickable(false)
//                .add(
//                    LatLng(-90.0,-90.0),
//                    LatLng(-90.0, 90.0),
//                    LatLng(90.0, 90.0),
//                    LatLng(90.0, -90.0)
//                )
//        )
//        backgroundPolygon.apply {
//            tag = "BackgroundPolygon"
//            fillColor = R.color.level_2
//        }

        // Add a marker in Sydney and move the camera
        val seoulAddress = geocoder.getFromLocationName("서울", 10).get(0)
        val seoul = LatLng(seoulAddress.latitude, seoulAddress.longitude)
        mMap.setMinZoomPreference(10f)
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(seoul, 11f))

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
        Toast.makeText(this, "CCTV 데이터를 불러올 때까지 잠시만 기다려주세요.", Toast.LENGTH_LONG).show()
        val markerAddr : Address = geocoder.getFromLocationName(marker.title, 10)[0]
        Log.d("PSY", "markerAddr : $markerAddr")
        Log.d("PSY", "markerAddr's feature : ${markerAddr.featureName}")

        try {
            val jsonKeyWord: String? =
                getJsonKeyWord(markerAddr.featureName) ?: jsonIndexing.get("종로구청")
            Log.d("PSY", "jsonKeyword : $jsonKeyWord")
            val cctvDataList: ArrayList<CCTVData> =
                HTTPTask.getCCTVdata(assetMananger, jsonKeyWord!!)
            Log.d("PSY", "cctvDataList size : ${cctvDataList.size}")
            for (i in 0 until cctvDataList.size) {
                Log.d("PSY", "cctvData loading : $i / ${cctvDataList.size}")
                cctvMarker.add(
                    mMap.addMarker(
                        MarkerOptions()
                            .position(cctvDataList[i].position)
                            .title(cctvDataList[i].location)
                            .snippet(cctvDataList[i].info)
                            .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_secondary_cctv))
                    )
                )
            }
        } catch (e : Exception) {
            e.printStackTrace()
        }
    }

    /**
     * getJsonKeyWord(String?)
     *
     * 현재 마커 featureName을 이용하여 jsonobject 검색을 위한 키워드 String 반환.
     *
     * feature : "동작구"
     * jsonIndex : mapOf("동작구청" to "dongjak")
     */
    fun getJsonKeyWord(feature: String?): String? {
        try {
            for (i in jsonIndexing.keys) {
                if (i.contains(feature.toString()) || feature!!.contains(i) || feature.equals(i)) {
                    return jsonIndexing.get(i).toString()
                }
            }
        } catch (e : Exception) {
            e.printStackTrace()
        }
        return null
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
        this.supportActionBar!!.setTitle(marker.title)
        return true
    }
}