package com.web.weather.db

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.web.weather.model.WeatherItem
import java.lang.reflect.Type


class WeatherConverter {

    @TypeConverter
    fun StringToWeatherList(mWeather : String): List<WeatherItem>{
        val gson = Gson();
        val type: Type = object : TypeToken<List<WeatherItem>>() {}.type
        return gson.fromJson(mWeather,type)
    }
    @TypeConverter
    fun WeatherListToString(list: List<WeatherItem>):String{
        val gson = Gson();
        return gson.toJson(list);
    }

}