package com.izainab.myweatherapp.data.meteoAPIDataSource.dto

import android.annotation.SuppressLint
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@SuppressLint("UnsafeOptInUsageError")
@Serializable
data class CurrentDto (
    val time: String,
    val interval: Double,
    @SerialName("temperature_2m")
    val temperature2m: Double,
    @SerialName("relative_humidity_2m")
    val relativeHumidity2m: Double,
    @SerialName("uv_index")
    val uvIndex: Double,
    @SerialName("is_day")
    val isDay: Int,
    @SerialName("precipitation_probability")
    val rain: Double,
    @SerialName("weather_code")
    val weatherCode: Int,
    @SerialName("surface_pressure")
    val surfacePressure: Double,
    @SerialName("wind_speed_10m")
    val windSpeed10m: Double,

)