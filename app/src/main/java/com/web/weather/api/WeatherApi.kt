package com.web.weather.api

import com.web.weather.model.WeatherDetails
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.Query

interface WeatherApi {

    @GET("data/2.5/weather/")
    suspend fun getCityWeather(@Query("q") cityNam :String ,
                               @Query("appid") appid :String) : WeatherDetails

}