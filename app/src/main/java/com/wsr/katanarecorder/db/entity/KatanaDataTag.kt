package com.wsr.katanarecorder.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "katana_data_tag_table",
    foreignKeys = [
        ForeignKey(
            entity = KatanaData::class,
            parentColumns = ["id"],
            childColumns = ["katana_data_id"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = Tag::class,
            parentColumns = ["id"],
            childColumns = ["tag_id"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class KatanaDataTag(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "katana_data_id") val katanaDataId: Int,
    @ColumnInfo(name = "tag_id") val TagId: Int
)