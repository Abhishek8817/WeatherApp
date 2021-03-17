package com.web.weather.repository

import android.app.Application
import android.content.Context
import com.web.weather.api.ApiClient
import com.web.weather.api.Constant
import com.web.weather.db.WeatherDao
import com.web.weather.db.WeatherRoomDatabase
//import com.web.weather.db.WeatherDao
//import com.web.weather.db.WeatherRoomDatabase
import com.web.weather.model.WeatherDetails

class WeatherRepository(mContext: Context) {
    private lateinit var mWeatherDb : WeatherDao;

    init {
     val database by lazy { WeatherRoomDatabase.getDataBase(mContext)}
     mWeatherDb = database.weatherDao()
    }

    suspend fun getWeather(cityNam: String ) : WeatherDetails{
      return ApiClient.getWeatherAPi().getCityWeather(cityNam, Constant.APP_ID)
    }

    suspend fun saveOfflineWeather(mWeatherDetials : WeatherDetails){
        mWeatherDb.insert(mWeatherDetials)
    }


}