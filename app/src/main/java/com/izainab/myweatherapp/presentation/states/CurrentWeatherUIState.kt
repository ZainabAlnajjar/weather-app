package com.izainab.myweatherapp.presentation.states

data class CurrentWeatherUIState(
    val rain: Int,
    val relativeHumidity2m: Int,
    val uvIndex: Int,
    val surfacePressure: Int,
    val temperature2m: Int,
    val temperature2mMin: Int,
    val temperature2mMax: Int,
    val windSpeed10m: Int,
    val weatherCode: Int,
    val time: String,
    val isDay: Boolean,
)