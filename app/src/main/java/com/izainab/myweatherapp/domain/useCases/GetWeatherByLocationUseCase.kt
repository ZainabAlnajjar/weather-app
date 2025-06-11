package com.izainab.myweatherapp.domain.useCases

import com.izainab.myweatherapp.domain.entities.Location
import com.izainab.myweatherapp.domain.entities.WeatherInfo
import com.izainab.myweatherapp.domain.repositories.WeatherRepository

class GetWeatherByLocationUseCase(
    private val weatherRepository: WeatherRepository,
) {

    suspend fun getWeatherByLocation(location: Location): WeatherInfo{
        return weatherRepository.getWeatherByLocation(location)
    }
}