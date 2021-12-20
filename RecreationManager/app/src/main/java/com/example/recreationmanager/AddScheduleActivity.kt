package com.example.recreationmanager

import android.os.Bundle
import android.view.MotionEvent
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.ui.AppBarConfiguration
import com.example.recreationmanager.databinding.ActivityAddscheduleBinding
import java.lang.Exception

class AddScheduleActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityAddscheduleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAddscheduleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        try {
            supportActionBar!!.setDisplayShowTitleEnabled(false)
            supportActionBar!!.setTitle(intent.getIntExtra("date", 0))
        } catch (e : Exception) {
            e.printStackTrace()
        }

        binding.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        try {
            if (event!!.action == MotionEvent.ACTION_OUTSIDE) {
                return false
            }
        }catch (e : Exception) {
            e.printStackTrace()
        }
        return true
    }
}