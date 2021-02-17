package com.wsr.katanarecorder.main.list.detail.show.view_holder

import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.wsr.katanarecorder.binding_adapter.ImageViewBindingAdapter.showImage
import com.wsr.katanarecorder.databinding.ItemListShowTopImageBinding

class ShowItemTopImageHolder(private val binding: ItemListShowTopImageBinding) : RecyclerView.ViewHolder(binding.root) {
    fun setBind(imageName: String?){
        binding.run {
            listShowImage.showImage(imageName)
        }
    }
}