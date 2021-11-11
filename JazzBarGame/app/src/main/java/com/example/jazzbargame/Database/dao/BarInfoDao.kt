package com.example.jazzbargame.Database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.jazzbargame.entity.BarInfoEntity

@Dao
interface BarInfoDao {

    @Insert (onConflict = OnConflictStrategy.REPLACE)
    fun insert(customer : BarInfoEntity)

    @Query ("SELECT * FROM BarInfoEntity")
    fun findAll() : List<BarInfoEntity>

    @Query ("DELETE FROM BarInfoEntity")
    fun deleteAll()

    @Query ("SELECT COUNT(*) FROM BarInfoEntity")
    fun getSize() : Int

}