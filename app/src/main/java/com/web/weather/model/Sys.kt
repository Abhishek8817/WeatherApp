package com.web.weather.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import com.google.gson.annotations.SerializedName


data class Sys(

	@field:SerializedName("country")
	val country: String? = null,

	@field:SerializedName("sunrise")
	val sunrise: Int? = null,

	@field:SerializedName("sunset")
	val sunset: Int? = null,

	@ColumnInfo(name = "sys_id" )
	@field:SerializedName("id")
	val id: Int,

	@field:SerializedName("type")
	val type: Int,

	@field:SerializedName("message")
	val message: Double
)