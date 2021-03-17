package com.web.weather.api

import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {

    private val mRetrofit : Retrofit =
            Retrofit.Builder()
                    .baseUrl(Constant.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
                    .addCallAdapterFactory(CoroutineCallAdapterFactory())
                    .client(getHttpClient())
                    .build();

    fun getHttpClient(): OkHttpClient{
        val client = OkHttpClient.Builder();
        val logging : HttpLoggingInterceptor= HttpLoggingInterceptor();
        logging.level =HttpLoggingInterceptor.Level.BODY;
        return client.addInterceptor(logging).build()
    }

    fun getWeatherAPi() : WeatherApi{
        return mRetrofit.create(WeatherApi::class.java)
    }

}