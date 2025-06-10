package com.izainab.myweatherapp.domain.entities

data class DailyWeatherInfo (
    val time: String,
    val temperature2mMin: Int,
    val temperature2mMax: Int,
    val weatherCode: Int,
)