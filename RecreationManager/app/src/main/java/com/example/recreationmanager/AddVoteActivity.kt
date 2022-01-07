package com.example.recreationmanager

import android.app.AlertDialog
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recreationmanager.databinding.ActivityAddVoteBinding
import com.google.android.material.snackbar.Snackbar
import java.lang.Exception

class AddVoteActivity : AppCompatActivity() {

    private lateinit var binding : ActivityAddVoteBinding
    private lateinit var mAdapter : VoteContentAdapter
    private var voteContentList : ArrayList<VoteContentData> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAddVoteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mAdapter = VoteContentAdapter()
        mAdapter.setData(voteContentList)
        binding.addVoteList.layoutManager = LinearLayoutManager(this)
        binding.addVoteList.adapter = mAdapter

        try {
            supportActionBar!!.setTitle("공지사항 추가")
        } catch (e : Exception) {
            e.printStackTrace()
        }
    }

    override fun onStart() {
        super.onStart()

        binding.fabAdd.setOnClickListener {

        }

        binding.fabDone.setOnClickListener { view ->
            Snackbar.make(view, "공지사항이 추가되었습니다", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
            val voteData = VoteData(
                binding.addVoteTitle.text.toString(),
                binding.addVotePriority.checkedRadioButtonId,
                binding.addVoteStartTime.toString(),
                binding.addVoteEndTime.toString()
            )
            // 여기에서 DB에 추가
            finish()
        }
    }
}