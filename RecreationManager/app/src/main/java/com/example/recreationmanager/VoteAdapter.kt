package com.example.recreationmanager

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recreationmanager.databinding.ActivityVoteBinding
import com.example.recreationmanager.databinding.ItemVoteListBinding

/**
 * criteria : present / past
 * true -> present
 * false -> past
 */
class VoteAdapter() : RecyclerView.Adapter<VoteAdapter.ViewHolder>() {

    private var data : List<VoteData> = listOf()

    fun setData(list : List<VoteData>) {
        this.data = list
        notifyDataSetChanged()
    }

    inner class ViewHolder(val binding : ItemVoteListBinding) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(newData : VoteData) {
            binding.itemVoteList = newData
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemVoteListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(data[position])
    }

    override fun getItemCount(): Int = data.size

}