package com.wsr.katanarecorder.main.list.detail.edit

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.wsr.katanarecorder.databinding.ItemListEditContent4ChildBinding
import com.wsr.katanarecorder.db.entity.Tag
import com.wsr.katanarecorder.main.list.detail.edit.view_holder.EditTagItemHolder

class ListEditTagAdapter: ListAdapter<Tag, EditTagItemHolder>(DiffCallback()) {

    private class DiffCallback: DiffUtil.ItemCallback<Tag>(){
        override fun areItemsTheSame(oldItem: Tag, newItem: Tag): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Tag, newItem: Tag): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EditTagItemHolder {
        val inflater = LayoutInflater.from(parent.context)
        return EditTagItemHolder(ItemListEditContent4ChildBinding.inflate(inflater, parent, false))
    }

    override fun onBindViewHolder(holder: EditTagItemHolder, position: Int) {
        holder.tagName.text = getItem(position).name
    }
}