package com.wsr.katanarecorder.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.wsr.katanarecorder.db.entity.KatanaData
import com.wsr.katanarecorder.db.entity.KatanaDataTag
import com.wsr.katanarecorder.db.entity.Tag

@Dao
interface KatanaDatabaseDao {
    @Insert
    fun insertKatanaData(katanaData: KatanaData)

    @Insert
    fun insertTag(tag: Tag)

    @Query("SELECT * FROM katana_data_table")
    fun getAllFromKatanaDataTable(): LiveData<MutableList<KatanaData>>

    @Query("SELECT * FROM katana_data_tag_table")
    fun getAllFromKatanaDataTagTable(): LiveData<MutableList<KatanaDataTag>>

    @Query("SELECT * FROM tag_table")
    fun getAllFromTagTable(): LiveData<MutableList<Tag>>

    @Query("DELETE FROM katana_data_table")
    fun deleteAllInKatanaDataTable()
}