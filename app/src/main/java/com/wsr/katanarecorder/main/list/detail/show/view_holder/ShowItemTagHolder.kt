package com.wsr.katanarecorder.main.list.detail.show.view_holder

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import com.google.android.flexbox.*
import com.wsr.katanarecorder.databinding.ItemListShowTagBinding
import com.wsr.katanarecorder.db.entity.Tag
import com.wsr.katanarecorder.main.list.detail.show.ListShowTagAdapter

class ShowItemTagHolder(binding: ItemListShowTagBinding, context: Context) : RecyclerView.ViewHolder(binding.root) {
    private val listShowTagAdapter = ListShowTagAdapter()

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

            this.listShowTagRecyclerView.apply{
                setHasFixedSize(true)
                layoutManager = flexBoxLayoutManager
                adapter = listShowTagAdapter
            }
        }
    }

    fun setData(tagList: List<Tag>){
        listShowTagAdapter.submitList(tagList)
    }
}