package com.example.criminalcctv.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.criminalcctv.database.dao.CityNameDao
import com.example.criminalcctv.entity.CityNameEntity
import kotlinx.coroutines.internal.SynchronizedObject

@Database (entities = [CityNameEntity::class], version = 1)
abstract class MasterDataBase : RoomDatabase() {
    abstract fun cityNameDao() : CityNameDao

    companion object {
        private var instance : MasterDataBase? = null

        @Synchronized
        fun getInstance(context : Context) : MasterDataBase? {
            if (instance == null) {
                instance = Room.databaseBuilder(
                    context.applicationContext,
                    MasterDataBase::class.java,
                    "database-contacts"
                )
                    .allowMainThreadQueries()
                    .build()
            }
            return instance
        }
    }
}