package com.example.jazzbargame.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.jazzbargame.Database.dao.BarInfoDao
import com.example.jazzbargame.entity.BarInfoEntity

@Database (entities = [BarInfoEntity::class], version = 1)
abstract class BarInfoDatabase : RoomDatabase() {
    abstract fun BarInfoDao() : BarInfoDao

    // 싱글톤
    companion object {
        private var instance: BarInfoDatabase? = null

        @Synchronized
        fun getInstance(context : Context) : BarInfoDatabase? {
            if (instance == null) {
                synchronized(BarInfoDatabase::class) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        BarInfoDatabase::class.java,
                        "customer-database"
                    ).build()
                }
            }
            return instance
        }
    }
}