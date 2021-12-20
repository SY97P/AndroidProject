package com.example.recreationmanager

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recreationmanager.databinding.ItemGameListBinding

class ItemGameListAdapter : RecyclerView.Adapter<ItemGameListAdapter.ViewHolder>() {

    private var data : List<GameData> = listOf()
    private lateinit var onItemClickListener : OnItemClickListener

    interface OnItemClickListener {
        fun onClick(view : View, position : Int)
    }

    fun setItemClickListener(itemListener : OnItemClickListener) {
        this.onItemClickListener = itemListener
    }

    fun setData(list : List<GameData>) {
        this.data = list
        notifyDataSetChanged()
    }

    inner class ViewHolder(val binding: ItemGameListBinding) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(newData : GameData) {
            binding.itemGameList = newData
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemGameListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(data[position])
        holder.itemView.setOnClickListener {
            onItemClickListener.onClick(it, position)
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }
}