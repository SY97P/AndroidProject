package com.example.criminalcctv

import android.content.Intent
import android.location.Address
import android.location.Geocoder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.criminalcctv.databinding.ActivityLoadingBinding
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.LatLng
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Exception
import java.text.Format

class LoadingActivity : AppCompatActivity() {
    private lateinit var binding : ActivityLoadingBinding

    private lateinit var geocoder : Geocoder

    private var cityData : ArrayList<CrimeTypeData>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_loading)

        geocoder = Geocoder(this)

        binding.activityLoadingCrimeTypeAnswer.text = intent.getStringExtra("crimeType")

        binding.activityLoadingProgress.visibility = View.VISIBLE
        binding.activityLoadingIsLoading.visibility = View.VISIBLE
    }

    override fun onStart() {
        super.onStart()

        val mapsIntent = Intent(this, MapsActivity::class.java)
        Toast.makeText(this, "창원시는 구글맵 서버 오류로 인해 마산으로 마커 이동", Toast.LENGTH_LONG).show()
        CoroutineScope(Dispatchers.Main).launch {
            withContext(CoroutineScope(Dispatchers.Default).coroutineContext) {
                cityData = HTTPTask.getCityCrimeCount(intent.getIntExtra("crimeTypeIndex", 0))
                Log.d("PSY", "cityData : $cityData")
                if (cityData != null) {
                    // cityData -> crimeList + cityList + countList
                    var loadingCrimeList: ArrayList<String> = parseData(cityData!!, "crime")
                    var loadingCityList: ArrayList<String> = parseData(cityData!!, "city")
                    var loadingCountList: ArrayList<String> = parseData(cityData!!, "count")
                    //Log.d("PSY", "loadingCrimeList : $loadingCrimeList")
                    mapsIntent.putStringArrayListExtra("loadingCrimeList", loadingCrimeList)
                    mapsIntent.putStringArrayListExtra("loadingCityList", loadingCityList)
                    mapsIntent.putStringArrayListExtra("loadingCountList", loadingCountList)

                    // info -> address
                    val latlngList : ArrayList<String> = arrayListOf()
                    for (i in 0 until cityData!!.size) {
                        runOnUiThread {
                            Log.d("PSY", "current : ${String.format("%.2f", (i * 100 / 120).toDouble())}%")
                            binding.activityLoadingPortion.text = String.format("%.2f", (i * 100 / 120).toDouble()) + "%"
                            if (binding.activityLoadingPortion.text.equals("100.00%")) {
                                binding.activityLoadingPortion.text = "Loading is Done!"
                            }
                        }
                        var latlng : LatLng? = null
                        try {
                            var address = geocoder.getFromLocationName(cityData!![i].city, 10)[0]
                            //Log.d("PSY", "i : $i, cityName : ${cityData!![i].city}, address : $address")
                            if (cityData!![i].city.equals("도시이외")) {
                                address = geocoder.getFromLocationName("철원", 10)[0]
                            }
                            latlng = LatLng(address!!.latitude, address!!.longitude)
                        } catch (e :Exception) {
                            //Log.d("PSY", "address Exception : ${cityData!![i].city}")
                            var address : Address? = null
                            when (cityData!![i].city) {
                                "구리" -> {
                                    address = geocoder.getFromLocationName("구리시", 10)[0]
                                    //Log.d("PSY", "address : ${address}")
                                }
                                "창원" -> {
                                    address = geocoder.getFromLocationName("마산", 10)[0]
                                    //Log.d("PSY", "address : ${address}")
                                }
                                "기타도시" -> {
                                    address = geocoder.getFromLocationName("여주시", 10)[0]
                                    //Log.d("PSY", "address : ${address}")
                                }
                                else -> {
                                    address = geocoder.getFromLocationName("울릉", 10)[0]
                                    //Log.d("PSY", "address : ${address}")
                                }
                            }
                            latlng = LatLng(address!!.latitude, address!!.longitude)
                        }
                        //Log.d("PSY", "latlng : $latlng")
                        latlngList.add(latlng.toString())
                    }
                    mapsIntent.putStringArrayListExtra("latlngList", latlngList)
                    runOnUiThread {
                        binding.activityLoadingProgress.visibility = View.GONE
                        binding.activityLoadingIsLoading.visibility = View.GONE
                    }
                    startActivity(mapsIntent)
                }
            }
        }
    }

    private fun parseData(cityData: ArrayList<CrimeTypeData>, s: String): ArrayList<String> {
        var result = arrayListOf<String>()
        for (i in 0 until cityData.size) {
            when (s) {
                "crime" -> {
                    result.add(cityData[i].crime)
                }
                "city" -> {
                    result.add(cityData[i].city)
                }
                "count" -> {
                    result.add(cityData[i].count.toString())
                }
            }
        }
        //Log.d("PSY", "result : $result")
        return result
    }
}