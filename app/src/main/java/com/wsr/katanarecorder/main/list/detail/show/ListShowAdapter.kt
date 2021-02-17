package com.wsr.katanarecorder.main.list.detail.show

import android.view.LayoutInflater
import android.view.View.GONE
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.wsr.katanarecorder.binding_adapter.ImageViewBindingAdapter.showImage
import com.wsr.katanarecorder.databinding.*
import com.wsr.katanarecorder.db.entity.KatanaData
import com.wsr.katanarecorder.db.entity.Tag
import com.wsr.katanarecorder.main.list.detail.show.view_holder.*

class ListShowAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    private var katanaData: KatanaData = KatanaData()
    private var tagList: List<Tag> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        return when(viewType){
            VIEW_TYPE_TOP_IMAGE -> ShowItemTopImageHolder(ItemListShowTopImageBinding.inflate(inflater, parent, false))
            VIEW_TYPE_TITLE -> ShowItemTitleHolder(ItemListShowTitleBinding.inflate(inflater, parent, false))
            VIEW_TYPE_TAG -> ShowItemTagHolder(ItemListShowTagBinding.inflate(inflater, parent, false), parent.context)
            VIEW_TYPE_CONTENT_TEXT_VIEW -> ShowItemContentTextViewHolder(ItemListShowContentTextViewBinding.inflate(inflater, parent, false))
            else -> {
                //getItemViewTypeを通るので基本起こりえない
                ShowItemContentTextViewHolder(ItemListShowContentTextViewBinding.inflate(inflater, parent, false))
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when(position){
            0 -> VIEW_TYPE_TOP_IMAGE
            1 -> VIEW_TYPE_TITLE
            2 -> VIEW_TYPE_TAG
            else -> VIEW_TYPE_CONTENT_TEXT_VIEW
        }
    }

    override fun getItemCount(): Int {
        return katanaData.data.size + 3
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder){
            is ShowItemTopImageHolder -> holder.setBind(katanaData.imageName)
            is ShowItemTitleHolder -> holder.setBind(katanaData.title)
            is ShowItemTagHolder -> holder.setData(tagList)
            is ShowItemContentTextViewHolder -> holder.setBind(katanaData.data[position - 3].key, katanaData.data[position - 3].value)
        }
    }

    fun setData(katanaData: KatanaData){
        this.katanaData = katanaData
        notifyDataSetChanged()
    }

    fun setTagList(tagList: List<Tag>){
        this.tagList = tagList
        notifyDataSetChanged()
    }

    companion object{
        private const val VIEW_TYPE_TOP_IMAGE = -1
        private const val VIEW_TYPE_TITLE = -2
        private const val VIEW_TYPE_TAG = -3
        private const val VIEW_TYPE_CONTENT_TEXT_VIEW = 1
    }
}