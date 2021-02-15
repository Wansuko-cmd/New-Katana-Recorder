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
import kotlinx.coroutines.runBlocking

class ListViewModel(application: Application) : AndroidViewModel(application){
    private val katanaRepository: KatanaRepository
    val katanaData: LiveData<MutableList<KatanaData>>
    val katanaDataTag: LiveData<MutableList<KatanaDataTag>>
    val tag: LiveData<MutableList<Tag>>
    init{
        val katanaDatabaseDao: KatanaDatabaseDao = KatanaDatabase.getDatabase(application, viewModelScope).katanaDatabaseDao()
        katanaRepository = KatanaRepository(katanaDatabaseDao)
        katanaData = katanaRepository.katanaData
        katanaDataTag = katanaRepository.katanaDataTag
        tag = katanaRepository.tag
    }

    fun insertKatanaDataTag(katanaDataTag: KatanaDataTag) = viewModelScope.launch(Dispatchers.IO) {
        katanaRepository.insertKatanaDataTag(katanaDataTag)
    }

    fun getTagFromKatanaData(katanaDataId: Int): LiveData<List<Tag>>{
        val result: MutableLiveData<List<Tag>> = MutableLiveData()
        viewModelScope.launch(Dispatchers.IO) {
            result.postValue(katanaRepository.getTagFromKatanaData(katanaDataId))
        }
        return result
    }

}