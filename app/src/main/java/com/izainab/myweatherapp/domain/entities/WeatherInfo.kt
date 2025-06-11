package com.izainab.myweatherapp.domain.entities

data class WeatherInfo(
    val rain: Int,
    val relativeHumidity2m: Int,
    val uvIndex: Int,
    val surfacePressure: Int,
    val temperature2m: Int,
    val windSpeed10m: Int,
    val weatherCode: Int,
    val time: String,
    val isDay: Boolean,
    val todayHourlyWeatherInfo: List<HourlyWeatherInfo>,
    val weeklyWeatherInfo: List<DailyWeatherInfo>,
    val weatherUnits: WeatherUnits,
)