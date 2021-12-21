package com.example.recreationmanager.notice

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recreationmanager.databinding.ItemNoticeListBinding

class NoticeAdapter : RecyclerView.Adapter<NoticeAdapter.ViewHolder>() {

    private var data : List<NoticeData> = listOf()

    fun setData(list : List<NoticeData>) {
        this.data = list
        notifyDataSetChanged()
    }

    inner class ViewHolder(val binding : ItemNoticeListBinding) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(newData : NoticeData) {
            binding.itemNoticeList = newData
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemNoticeListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.noticeIndex.text = "${position+1}"
        holder.onBind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }
}