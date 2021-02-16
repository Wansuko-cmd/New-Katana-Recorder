package com.wsr.katanarecorder.repository

import androidx.lifecycle.LiveData
import com.wsr.katanarecorder.db.dao.KatanaDatabaseDao
import com.wsr.katanarecorder.db.entity.KatanaData
import com.wsr.katanarecorder.db.entity.KatanaDataTag
import com.wsr.katanarecorder.db.entity.Tag

class KatanaRepository(private val katanaDatabaseDao: KatanaDatabaseDao) {
    val allKatanaData: LiveData<MutableList<KatanaData>> = katanaDatabaseDao.getAllFromKatanaDataTable()
    val allTag: LiveData<MutableList<Tag>> = katanaDatabaseDao.getAllFromTagTable()

    fun insertKatanaData(katanaData: KatanaData){
        katanaDatabaseDao.insertKatanaData(katanaData)
    }

    fun insertTag(tag: Tag){
        katanaDatabaseDao.insertTag(tag)
    }

    fun insertKatanaDataTag(katanaDataTag: KatanaDataTag){
        katanaDatabaseDao.insertKatanaDataTag(katanaDataTag)
    }

    fun updateKatanaData(katanaData: KatanaData){
        katanaDatabaseDao.updateKatanaData(katanaData)
    }

    fun updateTag(tag: Tag){
        katanaDatabaseDao.updateTag(tag)
    }

    fun getTagFromKatanaData(katanaDataId: Int): LiveData<MutableList<Tag>>{
        return katanaDatabaseDao.getTagFromKatanaData(katanaDataId)
    }
}