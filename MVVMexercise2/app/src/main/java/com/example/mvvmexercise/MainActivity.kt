package com.example.mvvmexercise

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvmexercise.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.activity = this@MainActivity

        setRcv()
    }

    private fun setRcv() {
        val profileAdapter = ProfileAdapter(this)
        binding.mainRcv.layoutManager = LinearLayoutManager(this)
        binding.mainRcv.adapter = profileAdapter

        profileAdapter.data = listOf(
            ProflieData(name = "Kang", age = 26),
            ProflieData(name = "Kim", age = 25)
        )
        profileAdapter.notifyDataSetChanged()
    }

    fun btnClick(view : View) {
        Toast.makeText(this, "Button Click", Toast.LENGTH_LONG).show()
    }
}