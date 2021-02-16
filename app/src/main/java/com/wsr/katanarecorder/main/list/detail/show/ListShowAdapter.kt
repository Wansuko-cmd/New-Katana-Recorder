package com.wsr.katanarecorder.main.list.detail.show

import android.view.LayoutInflater
import android.view.View.GONE
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.wsr.katanarecorder.databinding.ItemListShowContent1Binding
import com.wsr.katanarecorder.databinding.ItemListShowContent2Binding
import com.wsr.katanarecorder.databinding.ItemListShowContent3Binding
import com.wsr.katanarecorder.db.entity.KatanaData
import com.wsr.katanarecorder.main.list.detail.show.view_holder.ShowItem1Holder
import com.wsr.katanarecorder.main.list.detail.show.view_holder.ShowItem2Holder
import com.wsr.katanarecorder.main.list.detail.show.view_holder.ShowItem3Holder

class ListShowAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    private var katanaData: KatanaData = KatanaData()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        return when(viewType){
            1 -> ShowItem1Holder(ItemListShowContent1Binding.inflate(inflater, parent, false))
            2 -> ShowItem2Holder(ItemListShowContent2Binding.inflate(inflater, parent, false))
            3 -> ShowItem3Holder(ItemListShowContent3Binding.inflate(inflater, parent, false))
            else -> TODO("エラー処理を書く")
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when(position){
            0 -> 1
            1 -> 2
            else -> 3
        }
    }

    override fun getItemCount(): Int {
        return katanaData.data.size + 2
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder){
            is ShowItem1Holder -> holder.bind()
            is ShowItem2Holder -> holder.bind()
            is ShowItem3Holder -> holder.bind(position - 2)
        }
    }

    private fun ShowItem1Holder.bind(){
        if(katanaData.imageName == null){
            image.visibility = GONE
        }
    }

    private fun ShowItem2Holder.bind(){
        title.text = katanaData.title
    }

    private  fun ShowItem3Holder.bind(position: Int){
        key.text = katanaData.data[position].key
        value.text = katanaData.data[position].value
    }

    fun setData(katanaData: KatanaData){
        this.katanaData = katanaData
        notifyDataSetChanged()
    }
}