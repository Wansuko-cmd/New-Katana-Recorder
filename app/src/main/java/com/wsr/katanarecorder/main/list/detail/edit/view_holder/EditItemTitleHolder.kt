package com.wsr.katanarecorder.main.list.detail.edit.view_holder

import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.RecyclerView
import com.wsr.katanarecorder.databinding.ItemListEditTitleBinding
import com.wsr.katanarecorder.databinding.ItemListEditTopImageBinding
import com.wsr.katanarecorder.main.list.detail.edit.EditViewModel

class EditItemTitleHolder(private val binding: ItemListEditTitleBinding) : RecyclerView.ViewHolder(binding.root) {
    fun setBind(viewLifecycleOwner: LifecycleOwner, editViewModel: EditViewModel){
        binding.run {
            lifecycleOwner = viewLifecycleOwner
            this.editViewModel = editViewModel

            executePendingBindings()
        }
    }
}