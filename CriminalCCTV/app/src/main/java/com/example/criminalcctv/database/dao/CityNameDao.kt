package com.example.criminalcctv.database.dao

import androidx.room.*
import com.example.criminalcctv.entity.CityNameEntity

@Dao
interface CityNameDao {
    @Insert (onConflict = OnConflictStrategy.REPLACE)
    fun insert(cityNameEntity: CityNameEntity)

    @Query ("SELECT * FROM CityNameEntity")
    fun findAll() : List<CityNameEntity>

    @Query ("DELETE FROM CityNameEntity")
    fun deletaAll()

    @Query ("SELECT COUNT(*) FROM CityNameEntity")
    fun getSize() : Int
}