package com.izainab.myweatherapp.presentation.states

data class WeatherUIState(
    val currentWeather: CurrentWeatherUIState? = null,
    val weatherUnitsUIState: WeatherUnitsUIState? = null,
    val hourlyWeatherUIState: List<HourlyWeatherUIState> = emptyList(),
    val dailyWeatherUIState: List<DailyWeatherUIState> = emptyList(),
    val location: String = "Unknown"
)