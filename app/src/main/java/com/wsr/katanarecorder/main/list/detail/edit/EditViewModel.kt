package com.wsr.katanarecorder.main.list.detail.edit

import android.net.Uri
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.wsr.katanarecorder.db.KatanaValue

class EditViewModel : ViewModel(){
    val title: MutableLiveData<String> = MutableLiveData<String>()
    val imageUri: MutableLiveData<Uri?> = MutableLiveData<Uri?>()
    val katanaValue: MutableLiveData<MutableList<KatanaValue>> = MutableLiveData<MutableList<KatanaValue>>()
}