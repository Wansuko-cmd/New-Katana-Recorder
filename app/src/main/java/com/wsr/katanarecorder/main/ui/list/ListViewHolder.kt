package com.wsr.katanarecorder.main.ui.list

import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.wsr.katanarecorder.databinding.ItemListContentBinding

class ListViewHolder(binding: ItemListContentBinding) : RecyclerView.ViewHolder(binding.root){
    val listTitle: TextView = binding.listTitle
}