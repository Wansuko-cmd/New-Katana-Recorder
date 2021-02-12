package com.wsr.katanarecorder.main.list.detail.edit.view_holder

import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.RecyclerView
import com.wsr.katanarecorder.databinding.ItemListEditContent3Binding
import com.wsr.katanarecorder.main.list.detail.edit.EditViewModel

class EditItem3Holder(private val binding: ItemListEditContent3Binding) : RecyclerView.ViewHolder(binding.root){

    fun setBind(viewLifecycleOwner: LifecycleOwner, editViewModel: EditViewModel, index: Int){
        binding.run {
            lifecycleOwner = viewLifecycleOwner
            this.editViewModel = editViewModel
            this.index = index
            executePendingBindings()
        }
    }
}