package com.wsr.katanarecorder.main.list.detail.edit

import android.app.Activity
import android.app.AlertDialog
import android.net.Uri
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner

class ListEditImageSetter(
        private val activity: FragmentActivity,
        private val editViewModel: EditViewModel
) :DefaultLifecycleObserver{

    private lateinit var getContent: ActivityResultLauncher<String>
    private lateinit var dispatchTakePicture: ActivityResultLauncher<Uri>

    private val registry = activity.activityResultRegistry

    override fun onCreate(owner: LifecycleOwner) {

        getContent =
                registry.register(
                        "select-key",
                        owner,
                        ActivityResultContracts.GetContent()
                ){
                    it?.let{
                        editViewModel.imageUri.postValue(it)
                    }
                }
    }

    fun selectImage() {
        val items = arrayOf("画像を選択")

        AlertDialog.Builder(activity)
                .setItems(items){ dialog, which ->
                    when(which){
                        0 -> getContent.launch("image/*")
                    }
                }
                .show()
    }
}