package com.example.recreationmanager.schedule

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.ui.AppBarConfiguration
import com.example.recreationmanager.choicehelper.MapsActivity
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
            val date: String? = intent.getStringExtra("date")
            var title : String? = null
            if (date != null || date != "") {
                title = date!!.substring(0, 11)
            } else {
                title = "일정 추가"
            }
            supportActionBar!!.setDisplayShowTitleEnabled(false)
            supportActionBar!!.setTitle(title)
        } catch (e: Exception) {
            e.printStackTrace()
        }

        val location = intent.getStringExtra("locationData")
        if (location != null || location != "") {
            binding.calendarLocation.text = location
        } else {
            Log.d("PSY", "intent로 넘어온 게 없음. Main -> Maps -> AddSchedule 로 오면서 intent가 생성되지 않음.")
        }

    }

    override fun onStart() {
        super.onStart()

        binding.calendarLocation.setOnClickListener {
            val intent = Intent(applicationContext, MapsActivity::class.java)
            intent.putExtra("fromWhere", "addSchedule")
            startActivityForResult(intent, 1234)
        }

        binding.fab.setOnClickListener { view ->
            Snackbar.make(view, "일정을 추가했습니다.", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
            val scheduleData = ScheduleData(
                binding.calendarTitle.text.toString(),
                binding.calendarStartTime.text.toString(),
                binding.calendarEndTime.text.toString(),
                when {
                    binding.calendarPriorityA.isChecked -> "A"
                    binding.calendarPriorityB.isChecked -> "B"
                    binding.calendarPriorityC.isChecked -> "C"
                    else -> "F"
                },
                binding.calendarLocation.text.toString(),
                binding.calendarNote.text.toString()
            )
            // 여기에서 DB로 넣는 작업이 필요함.
            finish()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        try {
            if (requestCode == 1234 && resultCode == RESULT_OK) {
                val location = data!!.getStringExtra("locationData")
                runOnUiThread {
                    binding.calendarLocation.text = location
                }
            } else {
                runOnUiThread {
                    binding.calendarLocation.text = "불러오기 실패"
                }
            }
        } catch (e :Exception) {
            e.printStackTrace()
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