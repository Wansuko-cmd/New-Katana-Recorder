package com.wsr.katanarecorder.main.list.detail.edit.view_holder

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import com.google.android.flexbox.*
import com.wsr.katanarecorder.databinding.ItemListEditTagBinding
import com.wsr.katanarecorder.db.entity.Tag
import com.wsr.katanarecorder.main.list.detail.edit.ListEditTagAdapter

class EditItemTagHolder(binding: ItemListEditTagBinding, context: Context) : RecyclerView.ViewHolder(binding.root) {
    private val listEditTagAdapter = ListEditTagAdapter()

    init{
        binding.run {
            val flexBoxLayoutManager = FlexboxLayoutManager(context)
            // 配置方向を指定
            flexBoxLayoutManager.flexDirection = FlexDirection.ROW
            // 折り返し方法を指定
            flexBoxLayoutManager.flexWrap = FlexWrap.WRAP
            // 主軸方向の揃え位置を指定
            flexBoxLayoutManager.justifyContent = JustifyContent.FLEX_START
            // 交差軸方向の揃え位置を指定
            flexBoxLayoutManager.alignItems = AlignItems.STRETCH

            this.listEditTagRecyclerView.apply{
                setHasFixedSize(true)
                layoutManager = flexBoxLayoutManager
                adapter = listEditTagAdapter
            }
        }
    }

    fun setData(tagList: List<Tag>){
        listEditTagAdapter.submitList(tagList)
    }
}