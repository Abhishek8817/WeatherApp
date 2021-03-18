package com.web.weather.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Ignore
import com.google.gson.annotations.SerializedName


data class WeatherItem(

	@field:SerializedName("icon")
	val icon: String? = null,

	@field:SerializedName("description")
	val description: String? = null,

	@field:SerializedName("main")
	val main: String? = null,

	@ColumnInfo(name="wti_id")
	@field:SerializedName("id")
	val id: Int? = null


)