package com.web.weather.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import com.google.gson.annotations.SerializedName



data class Clouds(

	@ColumnInfo(name = "cd_all" )
	@field:SerializedName("all")
	val all: Int? = null
)