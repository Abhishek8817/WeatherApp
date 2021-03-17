package com.web.weather.repository

import com.web.weather.api.ApiClient
import com.web.weather.api.Constant
import com.web.weather.model.WeatherDetails

class WeatherRepository {

    suspend fun getWeather(cityNam: String ) : WeatherDetails{
      return  ApiClient.getWeatherAPi().getCityWeather(cityNam, Constant.APP_ID)
    }


}