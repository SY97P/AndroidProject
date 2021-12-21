package com.example.recreationmanager.schedule

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recreationmanager.databinding.ItemScheduleListBinding

class ScheduleAdapter : RecyclerView.Adapter<ScheduleAdapter.ViewHolder>() {

    private var data : List<ScheduleData> = listOf()

    fun setData(list : List<ScheduleData>) {
        this.data = list
        notifyDataSetChanged()
    }

    inner class ViewHolder(val binding : ItemScheduleListBinding) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(newData : ScheduleData) {
            binding.itemScheduleList = newData
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemScheduleListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.scheduleIndex.text = "${position+1}"
        holder.onBind(data[position])
    }

    override fun getItemCount(): Int = data.size
}