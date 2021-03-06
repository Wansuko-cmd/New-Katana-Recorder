package com.wsr.katanarecorder.main.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.wsr.katanarecorder.databinding.ItemListContentBinding
import com.wsr.katanarecorder.db.entity.KatanaData

class ListAdapter : RecyclerView.Adapter<ListViewHolder>(){

    private var list: MutableList<KatanaData> = mutableListOf()

    var clickTitleOnListener: (id: Int) -> Unit = {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemListContentBinding.inflate(inflater, parent, false)
        return ListViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.listTitle.text = this.list[position].title

        holder.listTitle.setOnClickListener {
            clickTitleOnListener(list[position].id)
        }
    }

    fun setData(list: MutableList<KatanaData>){
        this.list = list
        notifyDataSetChanged()
    }
}