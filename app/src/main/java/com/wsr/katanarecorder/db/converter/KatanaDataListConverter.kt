package com.wsr.katanarecorder.db.converter

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.wsr.katanarecorder.db.KatanaValue

object KatanaDataListConverter {

    @JvmStatic
    @TypeConverter
    fun toKatanaList(value: String): List<KatanaValue>{
        val katanaType = object : TypeToken<List<KatanaValue>>() {}.type
        return Gson().fromJson(value, katanaType)
    }

    @JvmStatic
    @TypeConverter
    fun fromKatanaList(katanaDataList: List<KatanaValue>): String{
        val gson = Gson()
        return gson.toJson(katanaDataList)
    }
}