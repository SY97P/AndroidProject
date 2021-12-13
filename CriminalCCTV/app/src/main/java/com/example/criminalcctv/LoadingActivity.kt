package com.example.criminalcctv

import android.content.Intent
import android.location.Address
import android.location.Geocoder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.example.criminalcctv.databinding.ActivityLoadingBinding
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.LatLng
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

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

        val intent = Intent(this, MapsActivity::class.java)
        CoroutineScope(Dispatchers.Main).launch {
            withContext(CoroutineScope(Dispatchers.Default).coroutineContext) {
                cityData = HTTPTask.getCityCrimeCount(intent.getIntExtra("crimeTypeIndex", 0))
            }
            if (cityData != null) {
//                intent.putExtra("cityData", cityData)
                for (i in 0 until cityData!!.size) {
                    var name = "cityData_$i"
                    intent.putExtra(name, cityData!![i])
                }

                // info -> address
//                val cityLatLngList : ArrayList<LatLng> = arrayListOf()
                for (i in 0 until cityData!!.size) {
                    val address = geocoder.getFromLocationName(cityData!![i].city, 10)[0]
                    val latlng = LatLng(address.latitude, address.longitude)
//                    cityLatLngList.add(latlng)
                    var name = "latlngList_$i"
                    intent.putExtra(name, latlng)
                }
                runOnUiThread {
                    binding.activityLoadingProgress.visibility = View.GONE
                    binding.activityLoadingIsLoading.visibility = View.GONE
                }
                startActivity(intent)
            }
        }
    }
}