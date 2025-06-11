package com.izainab.myweatherapp.data.meteoAPIDataSource.dto

import android.annotation.SuppressLint
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@SuppressLint("UnsafeOptInUsageError")
@Serializable
data class CurrentUnitsDto (
    val time: String,
    val interval: String,
    @SerialName("temperature_2m")
    val temperature2m: String,
    @SerialName("relative_humidity_2m")
    val relativeHumidity2m: String,
    @SerialName("uv_index")
    val uvIndex: String,
    @SerialName("is_day")
    val isDay: String,
    @SerialName("precipitation_probability")
    val rain: String,
    @SerialName("weather_code")
    val weatherCode: String,
    @SerialName("surface_pressure")
    val surfacePressure: String,
    @SerialName("wind_speed_10m")
    val windSpeed10m: String,
)
