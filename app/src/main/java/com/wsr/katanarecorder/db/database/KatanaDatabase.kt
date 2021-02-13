package com.wsr.katanarecorder.db.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.sqlite.db.SupportSQLiteDatabase
import com.wsr.katanarecorder.db.dao.KatanaDatabaseDao
import com.wsr.katanarecorder.db.KatanaValue
import com.wsr.katanarecorder.db.converter.KatanaDataListConverter
import com.wsr.katanarecorder.db.entity.KatanaData
import com.wsr.katanarecorder.db.entity.KatanaDataTag
import com.wsr.katanarecorder.db.entity.Tag
import io.reactivex.Completable
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Database(entities = [KatanaData::class, KatanaDataTag::class, Tag::class], version = 1, exportSchema = false)
@TypeConverters(KatanaDataListConverter::class)
abstract class KatanaDatabase : RoomDatabase(){

    abstract fun katanaDatabaseDao(): KatanaDatabaseDao

    private class KatanaDatabaseCallBack(private val scope: CoroutineScope) : RoomDatabase.Callback(){

        override fun onOpen(db: SupportSQLiteDatabase){
            super.onOpen(db)
            INSTANCE?.let{ database ->
                scope.launch {
                    seeding(database.katanaDatabaseDao())
                }
            }
        }

        fun seeding(katanaDatabaseDao: KatanaDatabaseDao){
            Completable.fromAction{
                katanaDatabaseDao.deleteAllInKatanaDataTable()

                katanaDatabaseDao.insertKatanaData(
                        KatanaData(0, "備前長船盛光", null,
                                mutableListOf(
                                        KatanaValue("銘", "備前長船盛光", 3),
                                        KatanaValue("種別", "太刀", 3),
                                        KatanaValue("産地", "備前長船派", 3),
                                        KatanaValue("時代", "室町中期", 3),
                                        KatanaValue("刃長", "79cm", 3),
                                        KatanaValue("備考", "こちらは備前長船刀剣博物館にて貯蔵されている一振り。室町前期の太刀でありながら生ぶであり、大変貴重なものとなっている。", 3)
                                )
                        )
                )

                katanaDatabaseDao.insertKatanaData(
                        KatanaData(0, "テスト丸", null,
                                mutableListOf(
                                        KatanaValue("TEST", "これはテストです", 3),
                                        KatanaValue("Hello", "World", 3)
                                )
                        )
                )
            }
                    .subscribeOn(Schedulers.io())
                    .subscribe()
        }
    }

    companion object{
        @Volatile
        private var INSTANCE: KatanaDatabase? = null

        fun getDatabase(context: Context, scope: CoroutineScope): KatanaDatabase {
            val tempInstance = INSTANCE
            if(tempInstance != null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                        context.applicationContext,
                        KatanaDatabase::class.java,
                        "katana_database",
                )
                        .addCallback(KatanaDatabaseCallBack(scope))
                        .build()
                INSTANCE = instance
                return instance
            }
        }
    }
}