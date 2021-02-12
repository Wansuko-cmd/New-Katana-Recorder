package com.wsr.katanarecorder.main.list.detail.edit.view_holder

import android.widget.EditText
import androidx.recyclerview.widget.RecyclerView
import com.wsr.katanarecorder.databinding.ItemListEditContent3Binding

class EditItem3Holder(binding: ItemListEditContent3Binding) : RecyclerView.ViewHolder(binding.root){
    val key: EditText = binding.listEditKey
    val value: EditText = binding.listEditValue
}