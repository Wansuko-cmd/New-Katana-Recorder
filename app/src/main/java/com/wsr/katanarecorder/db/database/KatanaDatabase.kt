package com.wsr.katanarecorder.db.database

import android.content.Context
import android.util.Log
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
import kotlin.math.log

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
                katanaDatabaseDao.deleteAllInKatanaDataTagTable()
                katanaDatabaseDao.deleteAllInKatanaDataTable()
                katanaDatabaseDao.deleteAllInTagTable()

                /*KatanaDataのシーディング*/

                val katana = katanaDatabaseDao.insertKatanaData(
                        KatanaData(0, "備前長船盛光", null,
                                mutableListOf(
                                        KatanaValue("銘", "備前長船盛光", 1),
                                        KatanaValue("種別", "太刀", 1),
                                        KatanaValue("産地", "備前長船派", 1),
                                        KatanaValue("時代", "室町中期", 1),
                                        KatanaValue("刃長", "79cm", 1),
                                        KatanaValue("備考", "こちらは備前長船刀剣博物館にて貯蔵されている一振り。室町前期の太刀でありながら生ぶであり、大変貴重なものとなっている。", 1)
                                )
                        )
                )

                katanaDatabaseDao.insertKatanaData(
                        KatanaData(0, "テスト丸", null,
                                mutableListOf(
                                        KatanaValue("TEST", "これはテストです", 1),
                                        KatanaValue("Hello", "World", 1)
                                )
                        )
                )

                /*Tagのシーディング*/
                val tag1 = katanaDatabaseDao.insertTag(Tag(0, "備前伝", "red"))
                val tag2 = katanaDatabaseDao.insertTag(Tag(0, "山城伝", "blue"))
                val tag3 = katanaDatabaseDao.insertTag(Tag(0, "お気に入り", "yellow"))
                val tag4 = katanaDatabaseDao.insertTag(Tag(0, "所有", "orange"))
                val tag5 = katanaDatabaseDao.insertTag(Tag(0, "脇差", "green"))
                val tag6 = katanaDatabaseDao.insertTag(Tag(0, "テスト用", "purple"))

                /*KatanaDataとTagの中間テーブルのシーディング*/
                val result = katanaDatabaseDao.insertKatanaDataTag(KatanaDataTag(0, katana.toInt(), tag1.toInt()))
                //katanaDatabaseDao.insertKatanaDataTag(KatanaDataTag(0, 2, 2))
                //katanaDatabaseDao.insertKatanaDataTag(KatanaDataTag(0, 1, 3))
                katanaDatabaseDao.insertKatanaDataTag(KatanaDataTag(0, katana.toInt(), tag2.toInt()))
                katanaDatabaseDao.insertKatanaDataTag(KatanaDataTag(0, katana.toInt(), tag3.toInt()))
                katanaDatabaseDao.insertKatanaDataTag(KatanaDataTag(0, katana.toInt(), tag4.toInt()))
                katanaDatabaseDao.insertKatanaDataTag(KatanaDataTag(0, katana.toInt(), tag5.toInt()))
                katanaDatabaseDao.insertKatanaDataTag(KatanaDataTag(0, katana.toInt(), tag6.toInt()))


                Log.i("result", result.toString())

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