package com.example.jazzbargame.activity

import android.app.AlertDialog
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.ImageButton
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.example.jazzbargame.DEFINES
import com.example.jazzbargame.Database.BarInfoDatabase
import com.example.jazzbargame.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SplashActivity : AppCompatActivity() {

    private val CHANNEL_ID = "Jazz_Bar_Open"
    private val CHANNEL_NAME = "Jazz_Bar_Channel"
    private val TITLE = "Sepp's Bar"
    private val NOTIFICATION_ID = 0


    private lateinit var startButton: ImageButton
    private lateinit var selectButton : ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        DEFINES.barInfoDatabase = BarInfoDatabase.getInstance(this)

        CoroutineScope(Dispatchers.Main).launch {
            withContext(CoroutineScope(Dispatchers.IO).coroutineContext) {
                if (DEFINES.barInfoDatabase!!.BarInfoDao().getSize() == 0) {
                    val intent = Intent(this@SplashActivity, RegisterActivity::class.java)
                    startActivity(intent)
//                    showpopup(DEFINES.PUP.INIT)
                }
            }
        }

        startButton = findViewById(R.id.splash_button)
        selectButton = findViewById(R.id.splash_button_register)
    }

    override fun onStart() {
        super.onStart()

        // image button 클릭하면 mainActivity 로 전환.
        startButton.setOnClickListener {
            sendNotification("is now Opened")
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
//            showpopup(DEFINES.PUP.START)
        }

        selectButton.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
//            showpopup(DEFINES.PUP.REGIST)
        }
    }

    private fun showpopup(text : String) {
        val inflater = getSystemService(LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = inflater.inflate(R.layout.alert_dialog, null)
        val textView : TextView = view.findViewById(R.id.alert_text)
        textView.text = text

        val alertDialog = AlertDialog.Builder(this)
            .setTitle(DEFINES.PUP.TITLE)
            .setPositiveButton("Yes") { dialog, which ->
                var intent : Intent? = null
                when (text) {
                    DEFINES.PUP.INIT -> {
                        intent = Intent(this@SplashActivity, RegisterActivity::class.java)
                    }
                    DEFINES.PUP.START -> {
                        intent = Intent(this, MainActivity::class.java)
                    }
                    DEFINES.PUP.REGIST -> {
                        intent = Intent(this, RegisterActivity::class.java)
                    }
                    else -> {
                        intent = Intent(this, SplashActivity::class.java)
                    }
                }
                startActivity(intent)
            }
            .setNegativeButton("No", null)
            .create()
        Log.d("JBGAME", "intent : $intent")
        alertDialog.setView(view)
        alertDialog.show()
    }

    override fun onDestroy() {
        super.onDestroy()
        sendNotification("is now Closed")
    }

    override fun onBackPressed() {
        super.onBackPressed()
        moveTaskToBack(true)
        finishAndRemoveTask()
        System.exit(0)
    }


    @RequiresApi(Build.VERSION_CODES.O)
    private fun createNotificationChannel(notificationManager: NotificationManager) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                CHANNEL_ID, CHANNEL_NAME, NotificationManager.IMPORTANCE_HIGH
            ).apply {
                description = "Channel for Jazz Bar Game"
            }
            notificationManager.createNotificationChannel(channel)
        }
    }

    private fun sendNotification(text : String) {
        // intent + pendingIntent 설정
        val intent = Intent(this, MainActivity::class.java)
        val pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_ONE_SHOT)
        // channel 설정
        val notificationManager: NotificationManager = getSystemService(NOTIFICATION_SERVICE)
                as NotificationManager
        createNotificationChannel(notificationManager)
        // notification 설정
        val notification = NotificationCompat.Builder(this, CHANNEL_ID).apply {
            setSmallIcon(R.drawable.icon_notify)
            setContentTitle(TITLE)
            setContentText(text)
            setAutoCancel(true)
            setPriority(NotificationManager.IMPORTANCE_HIGH)
            setContentIntent(pendingIntent)
        }
        // notification 표현
        with(NotificationManagerCompat.from(this)) {
            notify(NOTIFICATION_ID, notification.build())
        }
    }
}