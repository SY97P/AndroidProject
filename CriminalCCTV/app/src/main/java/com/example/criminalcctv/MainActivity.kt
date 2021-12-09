package com.example.criminalcctv

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.criminalcctv.adapter.CrimeTypeAdapter
import com.example.criminalcctv.database.MasterDataBase
import com.example.criminalcctv.databinding.ActivityMainBinding
import com.example.criminalcctv.model.CrimeType
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private lateinit var mDatabase : MasterDataBase

    private var initialStart : Boolean = false

    private var cityNameList : ArrayList<String>? = null
    private var cityCrimeList : ArrayList<String>? = null

    private var clickedPosition : Int = 0

    private val crimeList : ArrayList<String> = arrayListOf(
        "절도", "장물", "사기", "횡령", "배임", "손괴", "살인", "강도", "방화", "강간",
        "폭행", "상해", "협박", "공갈", "약취와유인", "체포와감금", "폭력행위등 ( 단체등의구성.활동 )",
        "폭력행위등처벌에관한법률위반", "통화", "유가증권.인지.우표", "문서", "인장", "직무유기", "직권남용",
        "수뢰", "증뢰", "간통", "혼인빙자간음", "기타음란행위", "도박과복표", "신앙", "과실치사상",
        "업무상과실치사상", "실화", "명예", "권리행사방해", "신용업무경매", "주거침입", "비밀침해", "유기",
        "낙태", "아편", "교통방해", "공무방해", "도주와범인은닉", "위증과증거인멸", "무고", "공안을해하는죄",
        "내란의죄", "음용수에관한죄"
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.activity = this@MainActivity


        val intent = Intent(this, MapsActivity::class.java)
        CoroutineScope(Dispatchers.Main).launch {
            withContext(CoroutineScope(Dispatchers.Default).coroutineContext) {
                cityNameList = HTTPTask.getCityNameList()
                cityCrimeList = HTTPTask.getCityCrimeList(crimeType = crimeList[clickedPosition])
                intent.putExtra("cityName", cityNameList)
                intent.putExtra("cityCrime", cityCrimeList)
                startActivity(intent)
            }
        }
    }
}