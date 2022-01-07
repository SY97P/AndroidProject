package com.example.recreationmanager

import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recreationmanager.databinding.ItemVotecontentListBinding

class VoteContentAdapter : RecyclerView.Adapter<VoteContentAdapter.ViewHolder>() {
    private var data : List<VoteContentData> = listOf()
    private lateinit var onItemClickedListener : OnItemClickedListener

    interface OnItemClickedListener {
        fun onClick(view : View, position : Int)
    }

    fun setItemClickedListener(itemClickedListener : OnItemClickedListener) {
        this.onItemClickedListener = itemClickedListener
    }

    fun setData(list : List<VoteContentData>) {
        this.data = list
        notifyDataSetChanged()
    }

    inner class ViewHolder(val binding : ItemVotecontentListBinding) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(newData : VoteContentData) {
            binding.itemVoteContentList = newData
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemVotecontentListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(data[position])
        holder.itemView.setOnClickListener {
            onItemClickedListener.onClick(it, position)
        }
    }

    override fun getItemCount(): Int = data.size
}