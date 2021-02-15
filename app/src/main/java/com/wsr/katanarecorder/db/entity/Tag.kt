package com.wsr.katanarecorder.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tag_table")
data class Tag(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "tag_id") val id: Int,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "color") val color: String
)