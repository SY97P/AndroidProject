package com.example.recreationmanager.schedule

import android.content.Intent
import android.location.Geocoder
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.ui.AppBarConfiguration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recreationmanager.databinding.ActivityScheduleBinding

class ScheduleActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityScheduleBinding

    private lateinit var mAdapter : ScheduleAdapter
    private val geocoder = Geocoder(this)
    private var scheduleList : ArrayList<ScheduleData> = arrayListOf(
        ScheduleData("이것은 제목이다.", "시작시간", "종료시간", "B", geocoder.getFromLocationName("서울", 10)[0].toString(), "집 가고 싶다."),
        ScheduleData("그다음 제목이다.", "AM 10:00", "PM 17:00", "A", geocoder.getFromLocationName("안양", 10)[0].toString(), "으엏")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityScheduleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        try {
            val date : String? = intent.getStringExtra("date")
            val title : String = date!!.substring(0, 11)
            Log.d("PSY", "title : $title")
            supportActionBar!!.setDisplayShowTitleEnabled(true)
            supportActionBar!!.setTitle(title.toString())
        } catch (e : Exception) {
            e.printStackTrace()
        }

        // list inflate
        mAdapter = ScheduleAdapter()
        // DB에서 schedule을 불러오는 작업이 필요함.
        // 매번 DB에서 읽기를 시도해야 일정 추가후 finish()로 현 activity에 돌아올 때 리스트가 반영됨.
        mAdapter.setData(scheduleList.toList())
        binding.scheduleList.layoutManager = LinearLayoutManager(applicationContext)
        binding.scheduleList.adapter = mAdapter
    }

    override fun onStart() {
        super.onStart()

        binding.fab.setOnClickListener { view ->
            Snackbar.make(view, "일정을 추가합니다", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
            val intent = Intent(this, AddScheduleActivity::class.java)
            intent.putExtra("date", intent.getStringExtra("date"))
            startActivity(intent)
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