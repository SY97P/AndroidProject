package com.example.jazzbargame.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.jazzbargame.R
import com.example.jazzbargame.model.BarModel
import org.w3c.dom.Text

class BarAdapter : RecyclerView.Adapter<BarAdapter.ViewHolder>() {

    private lateinit var rList : ArrayList<BarModel>
    private lateinit var onItemClickListener : OnItemClickListener

    interface OnItemClickListener {
        fun onClick(view : View, position: Int)
    }

    fun setItemClickListener(itemClickListener: OnItemClickListener) {
        this.onItemClickListener = itemClickListener
    }

    fun setList(list : ArrayList<BarModel>) {
        this.rList = list
        notifyDataSetChanged()
    }

    inner class ViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        val itemImage : ImageView  = view.findViewById(R.id.bar_list_item_image)
        val itemName : TextView = view.findViewById(R.id.bar_list_item_name)
        val itemMoney : TextView = view.findViewById(R.id.bar_list_item_money)
        val itemDate : TextView = view.findViewById(R.id.bar_list_item_date)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.bar_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if (rList != null) {
            val item : BarModel = rList!![position]

            holder.itemImage.setImageResource(item.modelBarImage)
            holder.itemName.text = item.modelBarName
            holder.itemMoney.text = "$ ${item.modelProfit}/${item.modelGoal}"
            holder.itemDate.text = item.modelDate

            holder.itemView.setOnClickListener {
                onItemClickListener.onClick(it, position)
            }
        } else {
            Log.d("JBGAME", "rList is null")
        }
    }

    override fun getItemCount(): Int {
        return if (rList != null) rList!!.size else 0
    }
}