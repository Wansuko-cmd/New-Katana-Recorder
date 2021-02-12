package com.wsr.katanarecorder.main.list.detail.edit

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.wsr.katanarecorder.db.KatanaValue
import com.wsr.katanarecorder.db.SampleModel

class EditViewModel : ViewModel(){
    val title: MutableLiveData<String> = MutableLiveData<String>()
    val imageUrl: MutableLiveData<String> = MutableLiveData<String>()
    val katanaValue: MutableLiveData<MutableList<KatanaValue>> = MutableLiveData<MutableList<KatanaValue>>()
}