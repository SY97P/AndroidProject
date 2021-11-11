package com.example.jazzbargame.activity

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageButton
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.jazzbargame.DEFINES
import com.example.jazzbargame.R
import com.example.jazzbargame.adapter.CustomerAdapter
import com.example.jazzbargame.model.CustomerModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Exception
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {

    // Recycler adapter
    private lateinit var mAdapter: CustomerAdapter

    // view
    private lateinit var playerButton : ImageButton
    private lateinit var cancelButton : ImageButton
    private lateinit var profitText : TextView
    private lateinit var progressBar : ProgressBar
    private lateinit var listView : RecyclerView

    // list
    private var customerList: ArrayList<CustomerModel> = arrayListOf()
    private val imageButtonList: ArrayList<ImageButton> = arrayListOf()
    private val clickedList: ArrayList<Boolean> = arrayListOf()

    // cancel button
    private var hasFocus : Boolean = false
    private var customer : CustomerModel? = null

    private var goal : Int = 3500
    private var curr : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mAdapter = CustomerAdapter()

        refillCustomer()

        mAdapter.setList(customerList)
        val recyclerList = findViewById<RecyclerView>(R.id.main_list)
        recyclerList.layoutManager = LinearLayoutManager(this)
        recyclerList.adapter = mAdapter

        playerButton = findViewById(R.id.main_button_hole)
        cancelButton = findViewById(R.id.main_button_cancel)
        profitText = findViewById(R.id.main_goal)
        progressBar = findViewById(R.id.main_profit)
        listView = findViewById(R.id.main_list)

        imageButtonList.add(findViewById(R.id.main_button_1))
        imageButtonList.add(findViewById(R.id.main_button_2))
        imageButtonList.add(findViewById(R.id.main_button_3))
        imageButtonList.add(findViewById(R.id.main_button_4))
        imageButtonList.add(findViewById(R.id.main_button_5))
        for (i in 0 until imageButtonList.size) {
            clickedList.add(false)
        }

        progressBar.progress = curr
        progressBar.max = goal
        progressBar.min = 0

        profitText.text = "Goal Money : $goal"
    }

    /**
     * refillCustomer
     *
     * random 함수를 이용하여 무작위로 customer를 생성
     */
    private fun refillCustomer() {
        for (i in 0 until 10) {
            customerList.add(
                CustomerModel(
                    imageProfile = DEFINES.IMAGE_CANDI[DEFINES.range_01.random()],
                    name = DEFINES.NAME_CANDI[DEFINES.range_name.random()],
                    gender = DEFINES.GENDER_CANDI[DEFINES.range_01.random()],
                    money = DEFINES.range_money.random().toString()
                )
            )
        }
    }


    override fun onStart() {
        super.onStart()

        // music service
        Toast.makeText(this, "연주자를 클릭하여 재즈바가 열렸음을 알리세요.", Toast.LENGTH_LONG).show()
        findViewById<ImageButton>(R.id.main_button_hole).setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startService(intent)
        }

        thread(start = true) {

            if (customerList.isEmpty()) {
                refillCustomer()
            }
            // recycler click listener
            mAdapter.setItemClickListener(object : CustomerAdapter.OnItemClickListener {
                override fun onClick(view: View, position: Int) {
                    if (!hasFocus) {
                        hasFocus = true
                        customer = customerList[position]
                        customerList.removeAt(position)
                        mAdapter.setList(customerList)
                    } else {
                        Log.d("JBGAME", "이미 눌린 손님 있음.")
                    }
                }
            })

            cancelButton.setOnClickListener {
                if (!hasFocus) {
                    Toast.makeText(this@MainActivity, "선택한 손님이 없습니다.", Toast.LENGTH_LONG).show()
                } else {
                    hasFocus = false
                    if (customer != null) {
                        customerList.add(customer!!)
                    } else {
                        Log.d("JBGAME", "customer is null")
                    }
                    mAdapter.setList(customerList)
                    customer = null
                }
            }

            for (i in 0 until imageButtonList.size) {
                imageButtonList[i].setOnClickListener {
                    if (clickedList[i] == false) { // 빈자리 -> 사람 채워줘요, profit도 늘려줘요
                        if (customer != null) {
//                            Toast.makeText(this@MainActivity,
//                                "손님이 ${i + 1} 번째 의자에 앉았습니다.",
//                                Toast.LENGTH_LONG).show()
                            clickedList[i] = true
                            curr += customer!!.money.toInt()
                            runOnUiThread {
                                imageButtonList[i].setImageResource(customer!!.imageProfile)
                                profitText.text = "Goal Money : $ $curr / $goal"
                                progressBar.progress = curr
                            }
                            customer = null
                            hasFocus = false
                            if (curr >= goal) {
                                showpopup(DEFINES.PUP.GOAL_TEXT)
                            }
                        } else {
                            Toast.makeText(this@MainActivity,
                                "먼저 자리에 앉힐 손님을 선택해주세요.",
                                Toast.LENGTH_LONG).show()
                            hasFocus = false
                        }
                    } else { // 사람있어요 -> 없게 만들어요
                        clickedList[i] = false
                        runOnUiThread {
                            imageButtonList[i].setImageResource(R.drawable.image_chair)
                        }
                        Toast.makeText(this@MainActivity, "선택한 자리의 손님이 나갔습니다.", Toast.LENGTH_LONG)
                            .show()
                    }
                }
            }
        }
    }

    private fun showpopup(text: String) {
        val inflater = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = inflater.inflate(R.layout.alert_dialog, null)
        val textView: TextView = view.findViewById(R.id.alert_text)
        textView.text = text

        val alertDialog = AlertDialog.Builder(this)
            .setTitle(DEFINES.PUP.TITLE)
            .setPositiveButton("Yes") { dialog, which ->
                Toast.makeText(this@MainActivity, "고생하셨습니다.", Toast.LENGTH_LONG).show()
                CoroutineScope(Dispatchers.Main).launch {
                    withContext(CoroutineScope(Dispatchers.IO).coroutineContext) {
                        try {
                            DEFINES.selectedBar!!.profit = (DEFINES.selectedBar!!.profit.toInt() + curr).toString()
                            DEFINES.barInfoDatabase!!.BarInfoDao().insert(DEFINES.selectedBar!!)
                        } catch (e : Exception) {
                            Log.e("JBGAME", "DB null exception maybe")
                        }
                    }
                }
                finish()
            }
            .setNegativeButton("No", null)
            .create()
        alertDialog.setView(view)
        alertDialog.show()
    }
}