package com.wsr.katanarecorder.binding_adapter

import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Environment
import android.util.Log
import android.view.View.GONE
import android.widget.ImageView
import androidx.core.content.FileProvider
import androidx.databinding.BindingAdapter
import com.wsr.katanarecorder.BuildConfig
import com.wsr.katanarecorder.R
import com.wsr.katanarecorder.binding_adapter.ImageViewBindingAdapter.imagePath
import java.io.File
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

    @BindingAdapter("showImage")
    @JvmStatic
    fun ImageView.showImage(filename: String?){
        if(filename == null){
            this.visibility = GONE
            return
        }

        try{
            val path = context.getExternalFilesDir(Environment.DIRECTORY_PICTURES)
            val file = File(path, filename)
            val uri = FileProvider.getUriForFile(context, BuildConfig.APPLICATION_ID + ".provider", file)

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