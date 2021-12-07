package com.example.addresslatlngconvertor

import android.content.Intent
import android.content.pm.PackageManager
import android.location.Geocoder
import android.os.*
import androidx.appcompat.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import com.example.addresslatlngconvertor.databinding.ActivityMainBinding
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import java.lang.Exception
import java.util.*
import java.util.jar.Manifest
import kotlin.concurrent.thread
import kotlin.concurrent.timer
import kotlin.concurrent.timerTask

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    private lateinit var geocoder: Geocoder

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this@MainActivity, R.layout.activity_main)
        binding.activity = this@MainActivity

        geocoder = Geocoder(this)

    }

    override fun onStart() {
        super.onStart()

        binding.ToAddrButton.setOnClickListener {
            Toast.makeText(this, "latlng -> address 버튼", Toast.LENGTH_LONG).show()
            binding.invalidateAll()
        }
        binding.ToLatButton.setOnClickListener {
            var inputText : String = binding.inputAddr.text.toString()
            if (inputText == "") {
                inputText = "금천구"
            }
            val list = geocoder.getFromLocationName(inputText, 10)
            val lat : Double = list[0].latitude
            val lng : Double = list[0].longitude

            Log.d("PSY", "lat : $lat, lng : $lng")
            Log.d("PSY", "Address : ${list[0].toString()}")
            Log.d("PSY", "line : ${list[0].getAddressLine(0)}")

            binding.latText.text = lat.toString()
            binding.lngText.text = lng.toString()
            binding.fullAddress.text = list[0].getAddressLine(0)

            var count : Int = 8
            Handler(Looper.getMainLooper()).postDelayed({
                val timerTask : Timer = timer(period = 1000) {
                    if (count >= 0) {
                        count--
                        runOnUiThread {
                            binding.countText.text = "맵이동까지 ${count}초"
                        }
                    } else {
                        this.cancel()
                    }
                }
            }, 8000)

            val intent = Intent(this, MapsActivity::class.java)
            intent.putExtra("lat", lat)
            intent.putExtra("lng", lng)
            intent.putExtra("input", binding.inputAddr.text.toString())
            intent.putExtra("address", list[0].getAddressLine(0))
            startActivity(intent)

            binding.invalidateAll()
        }
    }
}
