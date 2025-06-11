package com.izainab.myweatherapp.domain.entities

import java.time.LocalDateTime

data class HourlyWeatherInfo(
    val time: LocalDateTime,
    val temperature2m: Int,
    val weatherCode: Int,
    val isDay: Boolean,
)