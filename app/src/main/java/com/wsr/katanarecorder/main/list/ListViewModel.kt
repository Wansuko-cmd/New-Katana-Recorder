package com.wsr.katanarecorder.main.list

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.wsr.katanarecorder.db.dao.KatanaDatabaseDao
import com.wsr.katanarecorder.db.database.KatanaDatabase
import com.wsr.katanarecorder.db.entity.KatanaData
import com.wsr.katanarecorder.db.entity.KatanaDataTag
import com.wsr.katanarecorder.db.entity.Tag
import com.wsr.katanarecorder.repository.KatanaRepository

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
}