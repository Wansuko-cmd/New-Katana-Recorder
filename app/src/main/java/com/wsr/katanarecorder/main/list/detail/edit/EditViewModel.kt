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
import com.wsr.katanarecorder.db.entity.Tag
import kotlinx.coroutines.delay
import kotlinx.coroutines.withTimeout
import java.io.File
import java.io.FileOutputStream
import java.lang.Exception
import java.util.*

class EditViewModel : ViewModel() {
    val title: MutableLiveData<String> = MutableLiveData<String>()
    val imageUri: MutableLiveData<Uri?> = MutableLiveData<Uri?>()
    val katanaValue: MutableLiveData<MutableList<KatanaValue>> = MutableLiveData<MutableList<KatanaValue>>()
    val tagList: MutableLiveData<List<Tag>> = MutableLiveData<List<Tag>>()

    val position: MutableLiveData<Int> = MutableLiveData()

    private var filename: String? = null

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
        this.filename = filename
    }

    fun addValue(listEditAdapter: ListEditAdapter, position: Int){
        katanaValue.value?.add(KatanaValue())
        listEditAdapter.notifyItemInserted(position)
        this.position.postValue(position + 1)
    }

    fun saveImage(activity: Activity): String?{
        val newFilename = UUID.randomUUID().toString() + ".jpg"
        val path = activity.getExternalFilesDir(Environment.DIRECTORY_PICTURES)
        val file = File(path, newFilename)

        if(isExternalStorageWritable()){
            val output = FileOutputStream(file)

            val buf = ByteArray(DEFAULT_BUFFER_SIZE)

            imageUri.value?.let { uri ->
                activity.contentResolver.openInputStream(uri)?.let { inputStream ->

                    var len: Int
                    while (inputStream.read(buf).let { len = it; it != -1 }) {
                        output.write(buf, 0, len)
                    }
                    output.flush()

                    //もともと設定してあった画像の削除
                    this.filename?.let{
                        val deleteFile = File(path, it)
                        deleteFile.delete()
                    }

                    return newFilename
                }
            }
        }
        return this.filename
    }

    //書けるかどうかを確認するための関数
    private fun isExternalStorageWritable(): Boolean{
        val state = Environment.getExternalStorageState()
        return Environment.MEDIA_MOUNTED == state
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