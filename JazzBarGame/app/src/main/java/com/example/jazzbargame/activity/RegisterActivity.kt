package com.example.jazzbargame.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.jazzbargame.R
import com.example.jazzbargame.fragment.BarSelectFragment

class RegisterActivity : AppCompatActivity() {

    private val transaction = supportFragmentManager.beginTransaction()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        transaction.add(R.id.register_frame, BarSelectFragment())
        transaction.addToBackStack(null)
        transaction.commit()
    }
}