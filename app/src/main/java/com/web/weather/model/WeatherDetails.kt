package com.web.weather.model

import androidx.room.*
import com.google.gson.annotations.SerializedName
import com.web.weather.db.WeatherConverter


//not compulsory to add the coloumn info and serializedname

@Entity( tableName = "weather_table")
data class WeatherDetails(

	@ColumnInfo(name = "wt_id" )
	@field:SerializedName("id")
	val id: Int?=null,

	@ColumnInfo(name = "wt_dt" )
	@field:SerializedName("dt")
	val dt: Int? = null,

	@ColumnInfo(name = "wt_cod")
	@field:SerializedName("cod")
	val cod: Int? = null,

	@PrimaryKey
	@ColumnInfo(name = "wt_name")
	@field:SerializedName("name")
	val name: String,

	@Embedded
	@field:SerializedName("coord")
	val coord: Coord? = null,

	@ColumnInfo(name = "wt_visibility")
	@field:SerializedName("visibility")
	val visibility: Int? = null,


	@TypeConverters(WeatherConverter::class)
	@field:SerializedName("weather")
	val weather: List<WeatherItem?>?=null,

	@Embedded
	@field:SerializedName("main")
	val main: Main? = null,

	@Embedded
	@field:SerializedName("clouds")
	val clouds: Clouds? = null,

	@Embedded
	@field:SerializedName("sys")
	val sys: Sys,

	@Embedded
	@field:SerializedName("wind")
	val wind: Wind? = null,

	// Added new coloumn to test migration
	@ColumnInfo(name = "wt_base")
	@field:SerializedName("base")
	val base: String? = null,
)