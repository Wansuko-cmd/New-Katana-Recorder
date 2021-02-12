package com.wsr.katanarecorder.binding_adapter

import android.graphics.BitmapFactory
import android.net.Uri
import android.util.Log
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.wsr.katanarecorder.R
import java.lang.Exception

object ImageViewBindingAdapter {

    @BindingAdapter("imagePath")
    @JvmStatic
    fun ImageView.imagePath(uri: Uri?){
        if(uri == null){
            this.setImageResource(R.drawable.ic_baseline_add_a_photo_24)
            return
        }
        try{
            val inputStream = context.contentResolver.openInputStream(uri)
            val image = BitmapFactory.decodeStream(inputStream)
            this.setImageBitmap(image)
            Log.i("I set image which path", uri.toString())
            return
        }catch (e: Exception){
            Log.e("missed setting image", e.toString())
            return
        }
    }
}