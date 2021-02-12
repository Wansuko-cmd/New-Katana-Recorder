package com.wsr.katanarecorder.main.list.detail.edit

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.wsr.katanarecorder.R
import com.wsr.katanarecorder.databinding.ItemListEditContent1Binding
import com.wsr.katanarecorder.databinding.ItemListEditContent2Binding
import com.wsr.katanarecorder.databinding.ItemListEditContent3Binding
import com.wsr.katanarecorder.db.SampleModel
import com.wsr.katanarecorder.main.list.detail.edit.view_holder.EditItem1Holder
import com.wsr.katanarecorder.main.list.detail.edit.view_holder.EditItem2Holder
import com.wsr.katanarecorder.main.list.detail.edit.view_holder.EditItem3Holder

class ListEditAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    private var data: SampleModel = SampleModel()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        return when(viewType){
            1 -> EditItem1Holder(ItemListEditContent1Binding.inflate(inflater, parent, false))
            2 -> EditItem2Holder(ItemListEditContent2Binding.inflate(inflater, parent, false))
            3 -> EditItem3Holder(ItemListEditContent3Binding.inflate(inflater, parent, false))
            else -> TODO("エラー処理を書く")
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when(position){
            0 -> 1
            1 -> 2
            else -> data.value[position - 2].type
        }
    }

    override fun getItemCount(): Int {
        return data.value.size + 2
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder){
            is EditItem1Holder -> holder.bind()
            is EditItem2Holder -> holder.bind()
            is EditItem3Holder -> holder.bind(position - 2)
        }
    }

    private fun EditItem1Holder.bind(){
        if(data.url == null){
            image.setImageResource(R.drawable.ic_baseline_add_a_photo_24)
        }
    }

    private fun EditItem2Holder.bind(){
        title.setText(data.title)
    }

    private fun EditItem3Holder.bind(position: Int){
        key.setText(data.value[position].key)
        value.setText(data.value[position].value)
    }

    fun setData(data: SampleModel){
        this.data = data
    }
}