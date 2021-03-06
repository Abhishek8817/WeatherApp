package com.web.weather.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.web.weather.model.WeatherDetails
import com.web.weather.repository.WeatherRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class WeatherDetailsViewModel : ViewModel() {

    private val TAG = WeatherDetailsViewModel::class.java.simpleName
    private val mWeatherRepository = WeatherRepository()
    private val mWeatherData = MutableLiveData<WeatherDetails>()
    val  mData : LiveData<WeatherDetails> get() = mWeatherData;

    fun getCityWeather(){
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val mResponse= mWeatherRepository.getWeather("Dhar");
                withContext(Dispatchers.Main){
                    Log.d(TAG , "Response : " +  mResponse.toString());
                    mWeatherData.value=mResponse
                }
            }catch (e: Exception){
                Log.d(TAG, e.message.toString());
            }
        }
    }
}