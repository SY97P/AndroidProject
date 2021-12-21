package com.example.recreationmanager.notice

import android.os.Bundle
import android.view.MotionEvent
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.ui.AppBarConfiguration
import com.example.recreationmanager.databinding.ActivityAddNoticeBinding
import java.lang.Exception

class AddNoticeActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityAddNoticeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAddNoticeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        try {
            setSupportActionBar(binding.toolbar)
            supportActionBar!!.setTitle("공지사항 추가")
        } catch (e :Exception) {
            e.printStackTrace()
        }

        binding.fab.setOnClickListener { view ->
            Snackbar.make(view, "공지사항이 추가되었습니다", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
            val noticeData = NoticeData(binding.noticeTitle.text.toString(), binding.noticeDate.text.toString())
            // 여기에서 DB에 추가
            finish()
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