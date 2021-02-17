package com.wsr.katanarecorder.main.list.detail.edit

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.RecyclerView
import com.wsr.katanarecorder.databinding.*
import com.wsr.katanarecorder.main.list.detail.edit.view_holder.*

class ListEditAdapter(
        private val viewLifecycleOwner: LifecycleOwner,
        private val editViewModel: EditViewModel
        )
    : RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        return when(viewType){
            VIEW_TYPE_TOP_IMAGE
            -> EditItemTopImageHolder(ItemListEditTopImageBinding.inflate(inflater, parent, false))
            VIEW_TYPE_TITLE
            -> EditItemTitleHolder(ItemListEditTitleBinding.inflate(inflater, parent, false))
            VIEW_TYPE_TAG
            -> EditItemTagHolder(ItemListEditTagBinding.inflate(inflater, parent, false), parent.context)
            VIEW_TYPE_CONTENT_EDIT_TEXT
            -> EditItemContentEditTextHolder(ItemListEditContentEditTextBinding.inflate(inflater, parent, false))
            else -> TODO("エラー処理を書く")
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when(position){
            0 -> VIEW_TYPE_TOP_IMAGE
            1 -> VIEW_TYPE_TITLE
            2 -> VIEW_TYPE_TAG
            else -> if(editViewModel.katanaValue.value != null) editViewModel.katanaValue.value!![position - 2].type else 0
        }
    }

    override fun getItemCount(): Int {
        return if(editViewModel.katanaValue.value != null) editViewModel.katanaValue.value!!.size + 2 else 0
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder){
            is EditItemTopImageHolder -> holder.setBind(viewLifecycleOwner, editViewModel)
            is EditItemTitleHolder -> holder.setBind(viewLifecycleOwner, editViewModel)
            is EditItemTagHolder -> editViewModel.tagList.value?.let { holder.setData(it) }
            is EditItemContentEditTextHolder -> holder.setBind(viewLifecycleOwner, editViewModel, position - 2)
        }
    }

    companion object{
        private const val VIEW_TYPE_TOP_IMAGE = -1
        private const val VIEW_TYPE_TITLE = -2
        private const val VIEW_TYPE_TAG = -3
        private const val VIEW_TYPE_CONTENT_EDIT_TEXT = 1
    }
}