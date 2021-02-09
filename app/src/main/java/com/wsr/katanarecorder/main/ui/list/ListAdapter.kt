package com.wsr.katanarecorder.main.ui.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.wsr.katanarecorder.databinding.ItemListContentBinding

class ListAdapter : RecyclerView.Adapter<ListViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemListContentBinding.inflate(inflater, parent, false)
        return ListViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return 5
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.listTitle.text = "Hello, ${position}"
    }
}