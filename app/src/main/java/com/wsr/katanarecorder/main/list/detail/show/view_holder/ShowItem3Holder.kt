package com.wsr.katanarecorder.main.list.detail.show.view_holder

import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.wsr.katanarecorder.databinding.ItemListShowContent3Binding

class ShowItem3Holder(binding: ItemListShowContent3Binding) : RecyclerView.ViewHolder(binding.root) {
    val key: TextView = binding.listShowKey
    val value: TextView = binding.listShowValue
}