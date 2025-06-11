package com.izainab.myweatherapp.presentation.states

data class DailyWeatherUIState(
    val time: String,
    val temperature2mMin: Int,
    val temperature2mMax: Int,
    val weatherCode: Int,
)