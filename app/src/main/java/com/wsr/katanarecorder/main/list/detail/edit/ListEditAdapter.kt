package com.wsr.katanarecorder.main.list.detail.edit

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.RecyclerView
import com.wsr.katanarecorder.databinding.ItemListEditContent1Binding
import com.wsr.katanarecorder.databinding.ItemListEditContent2Binding
import com.wsr.katanarecorder.databinding.ItemListEditContent3Binding
import com.wsr.katanarecorder.databinding.ItemListEditContent4Binding
import com.wsr.katanarecorder.main.list.detail.edit.view_holder.EditItem1Holder
import com.wsr.katanarecorder.main.list.detail.edit.view_holder.EditItem2Holder
import com.wsr.katanarecorder.main.list.detail.edit.view_holder.EditItem3Holder
import com.wsr.katanarecorder.main.list.detail.edit.view_holder.EditItem4Holder

class ListEditAdapter(
        private val viewLifecycleOwner: LifecycleOwner,
        private val editViewModel: EditViewModel
        )
    : RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        return when(viewType){
            1 -> EditItem1Holder(ItemListEditContent1Binding.inflate(inflater, parent, false))
            2 -> EditItem2Holder(ItemListEditContent2Binding.inflate(inflater, parent, false))
            3 -> EditItem3Holder(ItemListEditContent3Binding.inflate(inflater, parent, false))
            4 -> EditItem4Holder(ItemListEditContent4Binding.inflate(inflater, parent, false))
            else -> TODO("エラー処理を書く")
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when(position){
            0 -> 1
            1 -> 2
            2 -> 4
            else -> if(editViewModel.katanaValue.value != null) editViewModel.katanaValue.value!![position - 2].type else -1
        }
    }

    override fun getItemCount(): Int {
        return if(editViewModel.katanaValue.value != null) editViewModel.katanaValue.value!!.size + 2 else 0
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder){
            is EditItem1Holder -> holder.setBind(viewLifecycleOwner, editViewModel)
            is EditItem2Holder -> holder.setBind(viewLifecycleOwner, editViewModel)
            is EditItem3Holder -> holder.setBind(viewLifecycleOwner, editViewModel, position - 2)
            is EditItem4Holder -> editViewModel.tagList.value?.let { holder.setData(it) }
        }
    }
}