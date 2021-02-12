package com.wsr.katanarecorder.main.list.detail.edit

import android.net.Uri
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.wsr.katanarecorder.db.KatanaValue
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeout
import java.lang.Exception

class EditViewModel : ViewModel() {
    val title: MutableLiveData<String> = MutableLiveData<String>()
    val imageUri: MutableLiveData<Uri?> = MutableLiveData<Uri?>()
    val katanaValue: MutableLiveData<MutableList<KatanaValue>> = MutableLiveData<MutableList<KatanaValue>>()

    lateinit var listEditImageSetter: ListEditImageSetter

    fun setObserver(observer: ListEditImageSetter){
        this.listEditImageSetter = observer
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