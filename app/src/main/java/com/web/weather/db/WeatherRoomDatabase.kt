package com.web.weather.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.web.weather.model.WeatherDetails


@Database(entities = arrayOf(WeatherDetails::class)  , version = 3, exportSchema = false)
public abstract class WeatherRoomDatabase : RoomDatabase() {

    abstract fun weatherDao(): WeatherDao

    companion object{

        private var INSTANCE : WeatherRoomDatabase? = null;

        fun getDataBase(context : Context): WeatherRoomDatabase{
            return INSTANCE?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    WeatherRoomDatabase::class.java,
                    "weather_table"
                ).build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }
}