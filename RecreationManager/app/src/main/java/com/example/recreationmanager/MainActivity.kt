package com.example.recreationmanager

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recreationmanager.databinding.ActivityMainBinding
import java.util.*

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
    private val activityList : ArrayList<Intent> = arrayListOf(
//        Intent(this, MapsActivity::class.java),
//        Intent(this, GameActivity::class.java),
        Intent(this, ScheduleActivity::class.java)
    )
    private val calendar = Calendar.getInstance()
    private var clickedDate : Date = Date(
        calendar.get(Calendar.DATE), calendar.get(Calendar.MONTH), calendar.get(Calendar.DATE)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        mAdapter = ItemGameListAdapter()
        binding.mainGameList.layoutManager = LinearLayoutManager(this)
        binding.mainGameList.adapter = mAdapter
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

        mAdapter.run {
            setData(gameList)
            setItemClickListener(object : ItemGameListAdapter.OnItemClickListener {
//                val intent = Intent(this, GameActivity::class.java)
                override fun onClick(view: View, position: Int) {
                    if (position != 0) {
                        val intent = activityList[1]
                        intent.putExtra("game", gameList[position].gameName)
                        startActivity(intent)
                    } else {
                        val intent = activityList[0]
                        startActivity(intent)
                    }
                }

            })
        }
    }
}