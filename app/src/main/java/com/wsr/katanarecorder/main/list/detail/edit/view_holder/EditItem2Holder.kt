package com.wsr.katanarecorder.main.list.detail.edit.view_holder

import android.widget.EditText
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.RecyclerView
import com.wsr.katanarecorder.databinding.ItemListEditContent2Binding
import com.wsr.katanarecorder.main.list.detail.edit.EditViewModel

class EditItem2Holder(private val binding: ItemListEditContent2Binding) : RecyclerView.ViewHolder(binding.root){

    fun setBind(viewLifecycleOwner: LifecycleOwner, editViewModel: EditViewModel){
        binding.run {
            lifecycleOwner = viewLifecycleOwner
            this.editViewModel = editViewModel

            executePendingBindings()
        }
    }
}