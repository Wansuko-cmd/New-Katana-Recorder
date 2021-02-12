package com.wsr.katanarecorder.db

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class SampleDB{
    private val test1 = SampleModel(1, "備前長船盛光", null,
        mutableListOf(
            KatanaValue("銘", "備前長船盛光", 3),
            KatanaValue("種別", "太刀", 3),
            KatanaValue("産地", "備前長船派", 3),
            KatanaValue("時代", "室町中期", 3),
            KatanaValue("刃長", "79cm", 3),
            KatanaValue("備考", "こちらは備前長船刀剣博物館にて貯蔵されている一振り。室町前期の太刀でありながら生ぶであり、大変貴重なものとなっている。", 3)
        )
    )

    private val test2 = SampleModel(2, "テスト丸", null,
        mutableListOf(
            KatanaValue("TEST", "これはテストです", 3),
            KatanaValue("Hello", "World", 3)
        )
    )

    private val data: MutableLiveData<MutableList<SampleModel>> by lazy{
        MutableLiveData<MutableList<SampleModel>>()
    }

    init{
        data.value = mutableListOf(test1, test2)
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