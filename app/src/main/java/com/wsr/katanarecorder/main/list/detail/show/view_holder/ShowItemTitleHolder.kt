package com.wsr.katanarecorder.main.list.detail.show.view_holder

import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.wsr.katanarecorder.databinding.ItemListShowTitleBinding

class ShowItemTitleHolder(private val binding: ItemListShowTitleBinding) : RecyclerView.ViewHolder(binding.root) {
    fun setBind(title: String){
        binding.run {
            listShowTitle.text = title
        }
    }
}