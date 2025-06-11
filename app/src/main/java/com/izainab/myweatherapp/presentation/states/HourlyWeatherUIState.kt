package com.izainab.myweatherapp.presentation.states

data class HourlyWeatherUIState(
    val temperature2m: Int,
    val weatherCode: Int,
    val time: String,
    val isDay: Boolean,
)