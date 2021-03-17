package com.web.weather.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.web.weather.R
import com.web.weather.model.WeatherDetails
import com.web.weather.viewmodel.WeatherDetailsViewModel

class WeatherDetailsActivity : AppCompatActivity() {

    private val TAG = WeatherDetailsActivity::class.java.simpleName
    private  val mViewModel: WeatherDetailsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather_details)
        subscribeToModel()
        init()
    }

    fun init(){
        mViewModel.getCityWeather();
    }

    fun subscribeToModel(){
        mViewModel.mData.observe(this, Observer {
            updateUI(it);
        })
    }

    fun updateUI(mData : WeatherDetails){
        Toast.makeText(this,"" + mData.cod,Toast.LENGTH_SHORT).show()
        Log.d(TAG,""+ mData.toString())
    }

}