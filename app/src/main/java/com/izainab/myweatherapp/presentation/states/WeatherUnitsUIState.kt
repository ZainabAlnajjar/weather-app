package com.izainab.myweatherapp.presentation.states

data class WeatherUnitsUIState(
    val rain: String,
    val relativeHumidity2m: String,
    val temperature2m: String,
    val uvIndex: String,
    val surfacePressure: String,
    val windSpeed10m: String,
    val time: String,
)