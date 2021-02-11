package com.wsr.katanarecorder.db

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class SampleDB{
    private val test1 = SampleModel(1, "備前長船盛光", null,
        mutableListOf(
            KatanaValue("銘", "備前長船盛光", 1),
            KatanaValue("種別", "太刀", 1),
            KatanaValue("産地", "備前長船派", 1),
            KatanaValue("時代", "室町中期", 1),
            KatanaValue("刃長", "79cm", 1),
            KatanaValue("備考", "こちらは備前長船刀剣博物館にて貯蔵されている一振り。室町前期の太刀でありながら生ぶであり、大変貴重なものとなっている。", 1)
        )
    )

    private val data: MutableLiveData<MutableList<SampleModel>> by lazy{
        MutableLiveData<MutableList<SampleModel>>()
    }

    init{
        data.value = mutableListOf(test1)
    }

    fun getAll(): LiveData<MutableList<SampleModel>> {
        return data
    }

    fun save(status: SampleModel){
        for((index, value) in data.value!!.withIndex()){
            if(status.id == value.id) {
                data.value!![index] = status
                break
            }
        }
    }

    companion object{
        @Volatile
        private var INSTANCE: SampleDB? = null

        fun getDatabase(): SampleDB{
            val tempInstance = INSTANCE
            if(tempInstance != null) return tempInstance
            synchronized(this){
                val instance = SampleDB()
                INSTANCE = instance
                return instance
            }
        }
    }
}