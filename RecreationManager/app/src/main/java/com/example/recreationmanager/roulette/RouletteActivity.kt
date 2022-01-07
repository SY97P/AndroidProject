package com.example.recreationmanager.roulette

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.example.recreationmanager.R
import com.example.recreationmanager.databinding.ActivityRouletteBinding
import com.google.android.material.snackbar.Snackbar
import java.lang.Exception
import java.util.*

class RouletteActivity : AppCompatActivity() {

    private lateinit var binding : ActivityRouletteBinding

    private var settingDone : Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_roulette)
        try {
            supportActionBar!!.title = "룰렛"
        } catch (e : Exception) {
            e.printStackTrace()
        }
    }

    override fun onStart() {
        super.onStart()

//        binding.roulettePlate.setOnClickListener {
//            Log.d("PSY", "point location -> x : ${it.x}, y : ${it.y}")
//            if (!settingDone) {
//                binding.roulettePlate.editRouletteText()
//            }
//        }

        binding.rouletteFloatingDone.setOnClickListener {
            settingDone = true
            binding.rouletteFloating.visibility = View.GONE
        }

        binding.rouletteFloatingAdd.setOnClickListener {
            runOnUiThread {
                binding.roulettePlate.addRoulette()
            }
        }

        binding.rouletteFloatingRemove.setOnClickListener {
            runOnUiThread {
                binding.roulettePlate.removeRoulette()
            }
        }

        binding.rouletteButtonRun.setOnClickListener {
            val rotateListener = object : Roulette.RotateListener {
                override fun onRotateStart() {
                    runOnUiThread {
                        binding.rouletteResultText.text = "잠시 후 결과를 공개합니다!"
                    }
                }

                override fun onRatateEnd(result: String) {
                    runOnUiThread {
                        binding.rouletteResultText.text = "$result"
                        binding.rouletteResultImageFront.visibility = View.VISIBLE
                        binding.rouletteResultImageBack.visibility = View.VISIBLE
                    }
                }
            }
            if (settingDone) {
                val toDegree = (2000..10000).random().toFloat()
                binding.roulettePlate.rotateRoulette(toDegrees = toDegree, 3000, rotateListener)
            } else {
                Snackbar.make(binding.root, "아직 룰렛 세팅이 안 되었어요. 체크 버튼을 눌러주세요.", Snackbar.LENGTH_LONG)
                    .setAction("noSettingReady", null).show()
            }
        }

        binding.rouletteButtonSetting.setOnClickListener {
            settingDone = false
//            binding.rouletteResultImageBack.visibility = View.GONE
//            binding.rouletteResultImageBack.visibility = View.GONE
//            binding.rouletteResultText.text = "과연 결과는?!"
//            binding.rouletteFloating.visibility = View.VISIBLE
//            binding.roulettePlate.refreshDrawableState()
            val intent = this.intent
            finish()
            startActivity(intent)
        }
    }

}