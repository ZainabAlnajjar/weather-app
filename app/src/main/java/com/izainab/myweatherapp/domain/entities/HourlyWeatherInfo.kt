package com.izainab.myweatherapp.domain.entities

data class HourlyWeatherInfo(
    val time: String,
    val temperature2m: Int,
    val weatherCode: Int,
)