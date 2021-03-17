package com.web.weather.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.web.weather.model.WeatherDetails

@Dao
interface WeatherDao {

    @Insert(onConflict =OnConflictStrategy.IGNORE)
    suspend fun insert(details : WeatherDetails)

    @Query("DELETE FROM weather_table")
    suspend fun deleteAll()

//    @Query("SELECT * FROM weather_table")
//    suspend fun getAllDetails()
}