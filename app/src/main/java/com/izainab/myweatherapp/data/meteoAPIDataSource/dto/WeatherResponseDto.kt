package com.izainab.myweatherapp.data.meteoAPIDataSource.dto

import android.annotation.SuppressLint
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@SuppressLint("UnsafeOptInUsageError")
@Serializable
data class WeatherResponseDto(
    val latitude: Double,
    val longitude: Double,
    @SerialName("generationtime_ms")
    val generationTimeInMs: Double,
    @SerialName("utc_offset_seconds")
    val utcOffsetSeconds: Int,
    @SerialName("timezone")
    val timeZone: String,
    @SerialName("timezone_abbreviation")
    val timeZoneAbbreviation: String,
    val elevation: Double,

    @SerialName("current_units")
    val currentUnits: CurrentUnitsDto,
    @SerialName("current")
    val current: CurrentDto,
    @SerialName("hourly_units")
    val hourlyUnits: HourlyUnitsDto,
    @SerialName("hourly")
    val hourly: HourlyDto,
    @SerialName("daily_units")
    val dailyUnits: DailyUnitsDto,
    @SerialName("daily")
    val daily: DailyDto
)
