package com.wsr.katanarecorder.main.list.detail.edit

import android.app.AlertDialog
import android.net.Uri
import android.os.Environment
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.FileProvider
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import com.wsr.katanarecorder.BuildConfig
import java.io.File
import java.util.*

class ListEditImageSetter(
        private val activity: FragmentActivity,
        private val editViewModel: EditViewModel
) :DefaultLifecycleObserver{

    private lateinit var getContent: ActivityResultLauncher<String>
    private lateinit var dispatchTakePicture: ActivityResultLauncher<Uri>

    private val registry = activity.activityResultRegistry

    private  lateinit var uri: Uri

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

        dispatchTakePicture =
            registry.register(
                "take-keys",
                owner,
                ActivityResultContracts.TakePicture()
            ){
                if(it){
                    editViewModel.imageUri.postValue(uri)
                }
            }
    }

    fun selectImage() {
        val items = arrayOf("画像を選択", "撮影する")

        AlertDialog.Builder(activity)
                .setItems(items){ _, which ->
                    when(which){
                        0 -> getContent.launch("image/*")
                        1 -> takePicture()
                    }
                }
                .show()
    }

    private fun takePicture(){
        val filename = UUID.randomUUID().toString() + ".jpg"
        val path = activity.getExternalFilesDir(Environment.DIRECTORY_PICTURES)
        val file = File(path, filename)

        uri = FileProvider.getUriForFile(activity, BuildConfig.APPLICATION_ID + ".provider", file)
        dispatchTakePicture.launch(uri)
    }
}