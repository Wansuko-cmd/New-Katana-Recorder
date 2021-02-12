package com.wsr.katanarecorder.binding_adapter

import android.net.Uri
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.wsr.katanarecorder.R

object ImageViewBindingAdapter {

    @BindingAdapter("imageUrl")
    @JvmStatic
    fun ImageView.imageUrl(uri: Uri?){
        if(uri == null){
            this.setImageResource(R.drawable.ic_baseline_add_a_photo_24)
            return
        }
    }
}