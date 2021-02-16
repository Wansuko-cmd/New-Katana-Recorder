package com.wsr.katanarecorder.main.list

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.wsr.katanarecorder.db.dao.KatanaDatabaseDao
import com.wsr.katanarecorder.db.database.KatanaDatabase
import com.wsr.katanarecorder.db.entity.KatanaData
import com.wsr.katanarecorder.db.entity.KatanaDataTag
import com.wsr.katanarecorder.db.entity.Tag
import com.wsr.katanarecorder.repository.KatanaRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ListViewModel(application: Application) : AndroidViewModel(application){
    private val katanaRepository: KatanaRepository
    val allKatanaData: LiveData<MutableList<KatanaData>>
    val allTag: LiveData<MutableList<Tag>>

    lateinit var tag: MutableLiveData<MutableList<Tag>>

    init{
        val katanaDatabaseDao: KatanaDatabaseDao = KatanaDatabase.getDatabase(application, viewModelScope).katanaDatabaseDao()
        katanaRepository = KatanaRepository(katanaDatabaseDao)
        allKatanaData = katanaRepository.allKatanaData
        allTag = katanaRepository.allTag
    }

    fun setTag(katanaDataId: Int) = viewModelScope.launch(Dispatchers.IO){
        tag = katanaRepository.getTagFromKatanaData(katanaDataId) as MutableLiveData<MutableList<Tag>>
    }

    fun insertKatanaDataTag(katanaDataTag: KatanaDataTag) = viewModelScope.launch(Dispatchers.IO) {
        katanaRepository.insertKatanaDataTag(katanaDataTag)
    }

}