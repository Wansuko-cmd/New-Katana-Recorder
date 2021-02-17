package com.wsr.katanarecorder.main.list.detail.show

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.wsr.katanarecorder.databinding.ItemListTagBinding
import com.wsr.katanarecorder.db.entity.Tag
import com.wsr.katanarecorder.main.list.detail.show.view_holder.ShowTagItemHolder

class ListShowTagAdapter : ListAdapter<Tag, ShowTagItemHolder>(DiffCallback()) {

    private class DiffCallback : DiffUtil.ItemCallback<Tag>() {
        override fun areItemsTheSame(oldItem: Tag, newItem: Tag): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Tag, newItem: Tag): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShowTagItemHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ShowTagItemHolder(ItemListTagBinding.inflate(inflater, parent, false))
    }

    override fun onBindViewHolder(holder: ShowTagItemHolder, position: Int) {
        holder.tagName.text = getItem(position).name
    }
}