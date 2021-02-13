package com.wsr.katanarecorder.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.wsr.katanarecorder.db.KatanaValue

@Entity(tableName = "katana_data_table")
data class KatanaData(
    @PrimaryKey(autoGenerate = true) val id: Int = -404,
    @ColumnInfo(name = "title") val title: String = "",
    @ColumnInfo(name = "image_name") val imageName: String? = null,
    @ColumnInfo(name = "data") val data: MutableList<KatanaValue> = mutableListOf()
)