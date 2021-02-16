package com.wsr.katanarecorder.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.wsr.katanarecorder.db.entity.KatanaData
import com.wsr.katanarecorder.db.entity.KatanaDataTag
import com.wsr.katanarecorder.db.entity.Tag

@Dao
interface KatanaDatabaseDao {
    @Insert
    fun insertKatanaData(katanaData: KatanaData): Long

    @Insert
    fun insertKatanaDataTag(katanaDataTag: KatanaDataTag): Long

    @Insert
    fun insertTag(tag: Tag): Long

    @Query("SELECT * FROM katana_data_table")
    fun getAllFromKatanaDataTable(): LiveData<MutableList<KatanaData>>

    @Query("SELECT * FROM katana_data_tag_table")
    fun getAllFromKatanaDataTagTable(): LiveData<MutableList<KatanaDataTag>>

    @Query("SELECT * FROM tag_table")
    fun getAllFromTagTable(): LiveData<MutableList<Tag>>

    @Query("SELECT * FROM tag_table INNER JOIN katana_data_tag_table ON tag_id=tag_foreign_id WHERE katana_data_foreign_id=:katanaDataId")
    fun getTagFromKatanaData(katanaDataId: Int): LiveData<MutableList<Tag>>

    @Query("DELETE FROM katana_data_table")
    fun deleteAllInKatanaDataTable()

    @Query("DELETE FROM katana_data_tag_table")
    fun deleteAllInKatanaDataTagTable()

    @Query("DELETE FROM tag_table")
    fun deleteAllInTagTable()
}