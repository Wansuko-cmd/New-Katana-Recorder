package com.wsr.katanarecorder.main.list.detail.edit.view_holder

import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.RecyclerView
import com.wsr.katanarecorder.databinding.ItemListEditTopImageBinding
import com.wsr.katanarecorder.main.list.detail.edit.EditViewModel

class EditItemTopImageHolder(private val binding: ItemListEditTopImageBinding) : RecyclerView.ViewHolder(binding.root) {

    fun setBind(viewLifecycleOwner: LifecycleOwner, editViewModel: EditViewModel){
        binding.run {
            lifecycleOwner = viewLifecycleOwner
            this.editViewModel = editViewModel

            executePendingBindings()
        }
    }
}