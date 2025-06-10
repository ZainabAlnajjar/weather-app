package com.izainab.myweatherapp.data.meteoAPIDataSource.dto

import android.annotation.SuppressLint
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@SuppressLint("UnsafeOptInUsageError")
@Serializable
data class HourlyUnitsDto(
    val time: String,
    @SerialName("temperature_2m")
    val temperature2m: String,
    @SerialName("weather_code")
    val weatherCode: String,
)
