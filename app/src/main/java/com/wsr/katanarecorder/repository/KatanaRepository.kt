package com.wsr.katanarecorder.repository

import androidx.lifecycle.LiveData
import com.wsr.katanarecorder.db.entity.KatanaData
import com.wsr.katanarecorder.db.entity.KatanaDataTag
import com.wsr.katanarecorder.db.dao.KatanaDatabaseDao
import com.wsr.katanarecorder.db.entity.Tag

class KatanaRepository(private val katanaDatabaseDao: KatanaDatabaseDao) {
    val katanaData: LiveData<MutableList<KatanaData>> = katanaDatabaseDao.getAllFromKatanaDataTable()
    val katanaDataTag: LiveData<MutableList<KatanaDataTag>> = katanaDatabaseDao.getAllFromKatanaDataTagTable()
    val tag: LiveData<MutableList<Tag>> = katanaDatabaseDao.getAllFromTagTable()
}