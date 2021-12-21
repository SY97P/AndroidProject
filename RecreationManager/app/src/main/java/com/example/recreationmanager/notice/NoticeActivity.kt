package com.example.recreationmanager.notice

import android.content.Intent
import android.os.Bundle
import android.view.MotionEvent
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.ui.AppBarConfiguration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recreationmanager.databinding.ActivityNoticeBinding

class NoticeActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityNoticeBinding

    private lateinit var mAdapter : NoticeAdapter
    private var noticeList: ArrayList<NoticeData> = arrayListOf(
        NoticeData("흥부가 기가막혀", "2021-01-01"),
        NoticeData("놀부도 기가막혀", "2021-01-01"),
        NoticeData("콩쥐도 기가막혀", "2021-01-01"),
        NoticeData("얼쑤", "2021-01-01")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityNoticeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        try {
            setSupportActionBar(binding.toolbar)
            supportActionBar!!.setTitle("공지사항 목록")
        } catch (e : Exception) {
            e.printStackTrace()
        }

        mAdapter = NoticeAdapter()
        mAdapter.setData(noticeList)
        binding.scheduleList.layoutManager = LinearLayoutManager(this)
        binding.scheduleList.adapter = mAdapter
    }

    override fun onStart() {
        super.onStart()

        binding.fab.setOnClickListener { view ->
            Snackbar.make(view, "공지사항을 추가합니다", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
            val intent = Intent(this, AddNoticeActivity::class.java)
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