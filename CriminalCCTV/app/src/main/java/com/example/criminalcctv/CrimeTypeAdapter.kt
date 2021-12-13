package com.example.criminalcctv

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.recyclerview.widget.RecyclerView
import com.example.criminalcctv.databinding.ItemListCrimeBinding

class CrimeTypeAdapter : RecyclerView.Adapter<CrimeTypeAdapter.ViewHolder>() {
    private var data  = listOf<CrimeTypeData>()
    private lateinit var onItemClickListener : OnItemClickListener

    interface OnItemClickListener {
        fun onClick(view : View, position : Int)
    }

    fun setItemClickListener(itemClickListener : OnItemClickListener) {
        this.onItemClickListener = itemClickListener
    }

    fun setData(list : List<CrimeTypeData>) {
        this.data = list
        notifyDataSetChanged()
    }

    class ViewHolder(val binding : ItemListCrimeBinding) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(newData : CrimeTypeData) {
            binding.crimeTypeList = newData
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemListCrimeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
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