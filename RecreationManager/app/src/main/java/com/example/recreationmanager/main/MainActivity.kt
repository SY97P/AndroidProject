package com.example.recreationmanager.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recreationmanager.MapsActivity
import com.example.recreationmanager.R
import com.example.recreationmanager.databinding.ActivityMainBinding
import com.example.recreationmanager.notice.NoticeActivity
import com.example.recreationmanager.schedule.ScheduleActivity
import com.google.android.material.snackbar.Snackbar
import java.lang.Exception
import java.util.*
import kotlin.concurrent.timer

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private lateinit var mAdapter : ItemGameListAdapter
    private val gameList : List<GameData> = listOf(
        GameData(gameName = "지도", R.drawable.ic_game_temp),
        GameData("룰렛", R.drawable.ic_game_temp),
        GameData("마피아게임", R.drawable.ic_game_temp),
        GameData("라이어게임", R.drawable.ic_game_temp),
        GameData("악어입게임", R.drawable.ic_game_temp),
    )
//    private val activityList : ArrayList<Intent> = arrayListOf(
//        Intent(applicationContext, MapsActivity::class.java),
//        Intent(applicationContext, GameActivity::class.java),
//        Intent(applicationContext, ScheduleActivity::class.java)
//    )
    private val calendar = Calendar.getInstance()
    private var clickedDate : Date = Date(
        calendar.get(Calendar.DATE), calendar.get(Calendar.MONTH), calendar.get(Calendar.DATE)
    )
    private var noticeList : ArrayList<String> = arrayListOf(
        "흥부가 기가막혀", "놀부도 기가막혀", "콩쥐도 기가막혀", "얼쑤"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        mAdapter = ItemGameListAdapter()
        mAdapter.setData(gameList)
        binding.mainGameList.layoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
        binding.mainGameList.adapter = mAdapter

        // tool bar에 공지사항 있으면 출력될 수 있도록 함.
        try {
            var noticeIndex: Int = 0
            timer(period = 10000) {
                runOnUiThread {
                    if (noticeList.isEmpty()) {
                        supportActionBar!!.setTitle("공지가 없다!")
                    } else {
                        supportActionBar!!.setTitle(noticeList[noticeIndex])
                    }
                }
                noticeIndex++
                if (noticeIndex == noticeList.size) {
                    noticeIndex = 0
                }
            }
        } catch (e : Exception) {
            e.printStackTrace()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.notice_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        Snackbar.make(binding.root, "공지사항!", Snackbar.LENGTH_LONG)
            .setAction("Action", null).show()
        val intent = Intent(this, NoticeActivity::class.java)
        // 여기에서 notice DB로 뭔가함.
        startActivity(intent)
        return true
    }

    override fun onStart() {
        super.onStart()

        binding.mainCalendar.setOnDateChangeListener { view, year, month, dayOfMonth ->
            val intent = Intent(this, ScheduleActivity::class.java)
            calendar.set(year, month, dayOfMonth)
            val currentDate : Date = Date(
                calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DATE)
            )
            if (currentDate == clickedDate) {
                intent.putExtra("date", currentDate.toString())
                startActivity(intent)
            } else {
                clickedDate = currentDate
            }
        }

        mAdapter.setItemClickListener(object : ItemGameListAdapter.OnItemClickListener {
            val intent = Intent(applicationContext, MapsActivity::class.java)
            override fun onClick(view: View, position: Int) {
                if (position != 0) {
                    // 여기를 GameActivity로 바꿔야 함.
                    val intent = Intent(applicationContext, MapsActivity::class.java)
                    intent.putExtra("game", gameList[position].gameName)
                    startActivity(intent)
                } else {
                    val intent = Intent(applicationContext, MapsActivity::class.java)
                    intent.putExtra("fromWhere", "main")
                    startActivity(intent)
                }
            }

        })
    }
}