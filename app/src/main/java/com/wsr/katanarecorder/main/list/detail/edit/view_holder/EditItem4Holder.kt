package com.wsr.katanarecorder.main.list.detail.edit.view_holder

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.wsr.katanarecorder.databinding.ItemListEditContent4Binding
import com.wsr.katanarecorder.db.entity.Tag
import com.wsr.katanarecorder.main.list.detail.edit.ListEditTagAdapter

class EditItem4Holder(binding: ItemListEditContent4Binding) : RecyclerView.ViewHolder(binding.root) {
    private val listEditTagAdapter = ListEditTagAdapter()

    init{
        binding.run {
            this.listEditTagRecyclerView.apply{
                setHasFixedSize(true)
                layoutManager = LinearLayoutManager(context)
                adapter = listEditTagAdapter
            }
        }
    }

    fun setData(tagList: List<Tag>){
        listEditTagAdapter.submitList(tagList)
    }
}