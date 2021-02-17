package com.wsr.katanarecorder.main.list.detail.show.view_holder

import androidx.recyclerview.widget.RecyclerView
import com.wsr.katanarecorder.databinding.ItemListShowContentTextViewBinding
import com.wsr.katanarecorder.databinding.ItemListShowTagBinding

class ShowItemContentTextViewHolder(private val binding: ItemListShowContentTextViewBinding) : RecyclerView.ViewHolder(binding.root) {
    fun setBind(key: String, value: String) {
        binding.run {
            listShowKey.text = key
            listShowValue.text = value
        }
    }
}