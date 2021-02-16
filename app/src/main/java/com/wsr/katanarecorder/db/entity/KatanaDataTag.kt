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
            parentColumns = ["katana_data_id"],
            childColumns = ["katana_data_foreign_id"],
            onDelete = ForeignKey.CASCADE,
            onUpdate = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = Tag::class,
            parentColumns = ["tag_id"],
            childColumns = ["tag_foreign_id"],
            onDelete = ForeignKey.CASCADE,
            onUpdate = ForeignKey.CASCADE
        )
    ]
)
data class KatanaDataTag(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name="katana_data_tag_id") val id: Int,
    @ColumnInfo(name = "katana_data_foreign_id") val katanaDataId: Int,
    @ColumnInfo(name = "tag_foreign_id") val TagId: Int
)

//primaryKeys = ["katana_data_foreign_id", "tag_foreign_id"],