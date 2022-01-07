package com.example.recreationmanager

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recreationmanager.R
import com.example.recreationmanager.databinding.ActivityVoteBinding

class VoteActivity : AppCompatActivity() {

    private lateinit var binding : ActivityVoteBinding
    private lateinit var presentAdapter : VoteAdapter
    private lateinit var pastAdapter : VoteAdapter

    private val voteTestData1 : ArrayList<VoteData> = arrayListOf(
        VoteData("첫 번째 투표", R.id.addVote_priority_a, "am 1:00", "pm 1:00"),
        VoteData("두 번째 투표", R.id.addVote_priority_b, "am 2:00", "pm 2:00"),
        VoteData("세 번째 투표", R.id.addVote_priority_c, "am 3:00", "pm 3:00")
    )
    private val voteTestData2 : ArrayList<VoteData> = arrayListOf(
        VoteData("첫 투표", R.id.addVote_priority_a, "am 1:00", "pm 1:00"),
        VoteData("두 투표", R.id.addVote_priority_b, "am 2:00", "pm 2:00"),
        VoteData("세 투표", R.id.addVote_priority_c, "am 3:00", "pm 3:00")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_vote)

        presentAdapter = VoteAdapter()
        pastAdapter = VoteAdapter()
        binding.voteListPresent.layoutManager = LinearLayoutManager(this)
        binding.voteListPast.layoutManager = LinearLayoutManager(this)
        binding.voteListPresent.adapter = presentAdapter
        binding.voteListPresent.adapter = pastAdapter

        try {
            supportActionBar!!.title = "Vote"
        } catch (e : Exception) {
            e.printStackTrace()
        }
    }

    override fun onStart() {
        super.onStart()

        presentAdapter.setData(voteTestData1)
        pastAdapter.setData(voteTestData2)

        binding.fab.setOnClickListener {
            val intent = Intent(this, AddVoteActivity::class.java)
            startActivity(intent)
        }
    }
}