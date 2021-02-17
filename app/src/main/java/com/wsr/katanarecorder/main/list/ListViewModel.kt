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

class ListViewModel(application: Application, id: Int?) : AndroidViewModel(application){
    private val katanaRepository: KatanaRepository
    val allKatanaData: LiveData<MutableList<KatanaData>>
    val allTag: LiveData<MutableList<Tag>>

    var tag: LiveData<MutableList<Tag>>? = null

    init {
        val katanaDatabaseDao: KatanaDatabaseDao = KatanaDatabase.getDatabase(application, viewModelScope).katanaDatabaseDao()
        katanaRepository = KatanaRepository(katanaDatabaseDao)
        allKatanaData = katanaRepository.allKatanaData
        allTag = katanaRepository.allTag
        id?.let {
            tag = katanaRepository.getTagFromKatanaData(it)
        }
    }

    fun insertKatanaData(katanaData: KatanaData) = viewModelScope.launch(Dispatchers.IO) {
        katanaRepository.insertKatanaData(katanaData)
    }

    fun insertTag(tag: Tag) = viewModelScope.launch(Dispatchers.IO) {
        katanaRepository.insertTag(tag)
    }

    fun insertKatanaDataTag(katanaDataTag: KatanaDataTag) = viewModelScope.launch(Dispatchers.IO) {
        katanaRepository.insertKatanaDataTag(katanaDataTag)
    }

    fun updateKatanaData(katanaData: KatanaData) = viewModelScope.launch(Dispatchers.IO) {
        katanaRepository.updateKatanaData(katanaData)
    }

    fun updateTag(tag: Tag) = viewModelScope.launch(Dispatchers.IO) {
        katanaRepository.updateTag(tag)
    }
}