package com.example.mvvmexercise

import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmexercise.databinding.RcvListItemBinding

class ProfileVH (val binding : RcvListItemBinding) : RecyclerView.ViewHolder(binding.root) {
    fun onBind(data : ProflieData) {
        binding.user = data
    }
}