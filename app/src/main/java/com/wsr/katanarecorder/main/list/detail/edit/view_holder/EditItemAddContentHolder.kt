package com.wsr.katanarecorder.main.list.detail.edit.view_holder

import androidx.recyclerview.widget.RecyclerView
import com.wsr.katanarecorder.databinding.ItemListEditAddContentBinding
import com.wsr.katanarecorder.main.list.detail.edit.EditViewModel
import com.wsr.katanarecorder.main.list.detail.edit.ListEditAdapter

class EditItemAddContentHolder(private val binding: ItemListEditAddContentBinding) : RecyclerView.ViewHolder(binding.root) {
    fun setBind(editViewModel: EditViewModel, listEditAdapter: ListEditAdapter){
        binding.run {
            this.editViewModel = editViewModel
            this.listEditAdapter = listEditAdapter
        }
    }
}