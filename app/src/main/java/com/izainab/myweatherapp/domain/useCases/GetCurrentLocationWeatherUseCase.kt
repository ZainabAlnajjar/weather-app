package com.izainab.myweatherapp.domain.useCases

import com.izainab.myweatherapp.domain.entities.WeatherResponse
import com.izainab.myweatherapp.domain.repositories.WeatherRepository
import com.izainab.myweatherapp.domain.services.LocationService

class GetCurrentLocationWeatherUseCase(
    private val weatherRepository: WeatherRepository,
    private val locationService: LocationService
) {

    suspend fun getCurrentLocationWeather(): WeatherResponse {
        val currentLocation = locationService.getCurrentLocation()
        return weatherRepository.getWeatherByLocation(currentLocation)
    }
}