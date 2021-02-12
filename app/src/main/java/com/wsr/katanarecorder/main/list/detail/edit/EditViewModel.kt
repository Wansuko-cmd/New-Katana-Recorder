package com.wsr.katanarecorder.main.list.detail.edit

import android.app.Activity
import android.net.Uri
import android.os.Environment
import android.util.Log
import androidx.core.content.FileProvider
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.wsr.katanarecorder.BuildConfig
import com.wsr.katanarecorder.db.KatanaValue
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeout
import java.io.File
import java.lang.Exception

class EditViewModel : ViewModel() {
    val title: MutableLiveData<String> = MutableLiveData<String>()
    val imageUri: MutableLiveData<Uri?> = MutableLiveData<Uri?>()
    val katanaValue: MutableLiveData<MutableList<KatanaValue>> = MutableLiveData<MutableList<KatanaValue>>()

    lateinit var listEditImageSetter: ListEditImageSetter

    fun setObserver(observer: ListEditImageSetter){
        this.listEditImageSetter = observer
    }

    fun setUriFromString(activity: Activity, filename: String?){
        filename?.let{
            val path = activity.getExternalFilesDir(Environment.DIRECTORY_PICTURES)
            val file = File(path, filename)

            val uri = FileProvider.getUriForFile(activity, BuildConfig.APPLICATION_ID + ".provider", file)
            this.imageUri.postValue(uri)
        }
    }

    suspend fun checkSetData(): Boolean {
        return try {
            Log.i("ok", "I'll get the title...")
            withTimeout(1000) {
                while (true) {
                    if (title.value != null) break
                    Log.i("I wait for", "getting title...")
                    delay(100)
                }
                true
            }
        } catch (e: Exception) {
            Log.e("I missed getting title", "error: $e")
            false
        }
    }
}