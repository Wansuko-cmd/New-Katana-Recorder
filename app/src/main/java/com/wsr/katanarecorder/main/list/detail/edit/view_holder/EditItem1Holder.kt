package com.wsr.katanarecorder.main.list.detail.edit.view_holder

import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.RecyclerView
import com.wsr.katanarecorder.databinding.ItemListEditContent1Binding
import com.wsr.katanarecorder.main.list.detail.edit.EditViewModel

class EditItem1Holder(private val binding: ItemListEditContent1Binding) : RecyclerView.ViewHolder(binding.root){

    fun setBind(viewLifecycleOwner: LifecycleOwner, editViewModel: EditViewModel){
        binding.run{
            lifecycleOwner = viewLifecycleOwner
            this.editViewModel = editViewModel

            executePendingBindings()
        }
    }
}