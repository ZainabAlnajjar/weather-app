package com.izainab.myweatherapp.domain.repositories

import com.izainab.myweatherapp.domain.entities.Location
import com.izainab.myweatherapp.domain.entities.WeatherResponse

interface WeatherRepository {
   suspend fun getWeatherByLocation(location: Location): WeatherResponse
}