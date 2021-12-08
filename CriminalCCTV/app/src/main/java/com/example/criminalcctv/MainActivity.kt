package com.example.criminalcctv

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.criminalcctv.database.MasterDataBase
import com.example.criminalcctv.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private lateinit var mDatabase : MasterDataBase

    private var initialStart : Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.activity = this@MainActivity

        mDatabase = MasterDataBase.getInstance(this)!!

        // city name crawling
        CoroutineScope(Dispatchers.Main).launch {
            withContext(CoroutineScope(Dispatchers.IO).coroutineContext) {
                // 첫 실행일 경우
                if (mDatabase.cityNameDao().getSize() == 0 ) {
                    initialStart = true
                }
            }
            if (initialStart) {
                withContext(CoroutineScope(Dispatchers.Default).coroutineContext) {

                }
            }
        }

        val intent = Intent(this, MapsActivity::class.java)
        startActivity(intent)
    }
}