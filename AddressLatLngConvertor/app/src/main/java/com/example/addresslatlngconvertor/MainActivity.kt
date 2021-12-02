package com.example.addresslatlngconvertor

import android.content.Intent
import android.content.pm.PackageManager
import android.location.Geocoder
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import androidx.databinding.DataBindingUtil
import com.example.addresslatlngconvertor.databinding.ActivityMainBinding
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import java.util.jar.Manifest

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    private val geocoder = Geocoder(this)
    // FusedLocationProviderClient : 기기의 마지막 위치를 가져오기 위한 클래스
    private lateinit var fusedLocationClient : FusedLocationProviderClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.activity = this@MainActivity

        // 위치 권한 알림
        val locationPermissionRequest = registerForActivityResult(
            ActivityResultContracts.RequestMultiplePermissions()
        ) { permissions ->
            when {
                permissions.getOrDefault(android.Manifest.permission.ACCESS_FINE_LOCATION, false) -> {
                    Toast.makeText(this, "위치 권한 설정이 필요해요", Toast.LENGTH_LONG).show()
                }
                permissions.getOrDefault(android.Manifest.permission.ACCESS_COARSE_LOCATION, false) -> {
                    Toast.makeText(this, "위치 권한 설정이 필요해요", Toast.LENGTH_LONG).show()
                } else -> {
                    Toast.makeText(this, "앱을 시작합니다", Toast.LENGTH_LONG).show()
                }
            }
        }
        locationPermissionRequest.launch(arrayOf(
            android.Manifest.permission.ACCESS_FINE_LOCATION,
            android.Manifest.permission.ACCESS_COARSE_LOCATION
        ))
    }

    override fun onStart() {
        super.onStart()

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)
    }

    fun btnClick(view : View) {
        if (ActivityCompat.checkSelfPermission(this,
                android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                this,
                android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED
        ) {
            Toast.makeText(this, "위치권한 설정이 필요합니다", Toast.LENGTH_LONG).show()
        }
        when (view) {
            binding.ToAddrButton -> {
                fusedLocationClient.lastLocation.addOnSuccessListener {
                    val address = geocoder.getFromLocation(it.latitude, it.longitude, 1)
                    Toast.makeText(this, "주소 : ${address[0].subLocality}", Toast.LENGTH_LONG).show()
                }
                fusedLocationClient.lastLocation.addOnCanceledListener {
                    Toast.makeText(this, "마지막 주소 찾지 못함.", Toast.LENGTH_LONG).show()
                }
            }
            binding.ToLatButton -> {

                if (binding.inputAddr == null) {
                    Toast.makeText(this, "찾고자 하는 장소를 입력해주세요.", Toast.LENGTH_LONG).show()
                } else {
                    try {
                        val cor = geocoder.getFromLocationName(binding.inputAddr.text.toString(), 1)
                        Toast.makeText(this,
                            "좌표 : ${cor[0].latitude}, ${cor[0].longitude}",
                            Toast.LENGTH_LONG).show()
                        var lat : Double = cor[0].latitude
                        var lng : Double = cor[0].longitude
                        var intent = Intent()
                    } catch (e : Exception) {
                        Toast.makeText(this, "주소를 입력하세요.", Toast.LENGTH_LONG).show()
                    }
                }
            }
        }
    }
}