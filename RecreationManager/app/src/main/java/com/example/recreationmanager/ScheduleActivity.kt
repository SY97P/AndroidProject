package com.example.recreationmanager

import android.location.Geocoder
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.ui.AppBarConfiguration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recreationmanager.databinding.ActivityScheduleBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ScheduleActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityScheduleBinding

    private lateinit var mAdapter : ScheduleAdapter
    private val geocoder = Geocoder(this)
    private var scheduleList : ArrayList<ScheduleData> = arrayListOf(
        ScheduleData("이것은 제목이다.", "시작시간", "종료시간", 1, geocoder.getFromLocationName("서울", 10)[0], "집 가고 싶다.")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityScheduleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        try {
            val date : String? = intent.getStringExtra("date")
            val title : String = date!!.substring(10)
            Log.d("PSY", "title : $title")
            supportActionBar!!.setDisplayShowTitleEnabled(false)
            supportActionBar!!.setTitle(title)
        } catch (e : Exception) {
            e.printStackTrace()
        }

        // list inflate
        CoroutineScope(Dispatchers.Main).launch {
            mAdapter = ScheduleAdapter()
            binding.scheduleList.layoutManager = LinearLayoutManager(applicationContext)
            binding.scheduleList.adapter = mAdapter
            withContext(CoroutineScope(Dispatchers.Default).coroutineContext) {
                mAdapter.setData(scheduleList.toList())
            }
        }
    }

    override fun onStart() {
        super.onStart()

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
        } catch (e : Exception) {
            e.printStackTrace()
        }
        return true
    }
}