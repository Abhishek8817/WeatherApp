package com.web.weather.model

data class WeatherDetails(
	val dt: Int? = null,
	val coord: Coord? = null,
	val visibility: Int? = null,
	val weather: List<WeatherItem?>? = null,
	val name: String? = null,
	val cod: Int? = null,
	val main: Main? = null,
	val clouds: Clouds? = null,
	val id: Int? = null,
	val sys: Sys? = null,
	val base: String? = null,
	val wind: Wind? = null
)


