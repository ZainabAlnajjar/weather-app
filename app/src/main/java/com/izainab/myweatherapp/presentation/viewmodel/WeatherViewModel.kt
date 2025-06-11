package com.izainab.myweatherapp.presentation.viewmodel

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.izainab.myweatherapp.domain.services.LocationService
import com.izainab.myweatherapp.domain.useCases.GetWeatherByLocationUseCase
import com.izainab.myweatherapp.presentation.states.WeatherUIState
import com.izainab.myweatherapp.presentation.states.mapper.toCurrentWeatherUIState
import com.izainab.myweatherapp.presentation.states.mapper.toDailyWeatherUIStateList
import com.izainab.myweatherapp.presentation.states.mapper.toHourlyWeatherUIStateList
import com.izainab.myweatherapp.presentation.states.mapper.weatherUnitsUIState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class WeatherViewModel(
    private val getWeatherByLocationUseCase: GetWeatherByLocationUseCase,
    private val locationService: LocationService,
) : ViewModel() {


    private val _state = MutableStateFlow(WeatherUIState())
    val state = _state.asStateFlow()

    @RequiresApi(Build.VERSION_CODES.O)
    fun getWeather() {

        viewModelScope.launch(Dispatchers.IO) {
            val currentLocation = locationService.getCurrentLocation()
            val response = getWeatherByLocationUseCase.getWeatherByLocation(currentLocation)

            _state.update {
                _state.value.copy(
                    currentWeather = response.toCurrentWeatherUIState(),
                    weatherUnitsUIState = response.weatherUnits.weatherUnitsUIState(),
                    hourlyWeatherUIState = response.todayHourlyWeatherInfo.toHourlyWeatherUIStateList(),
                    dailyWeatherUIState = response.weeklyWeatherInfo.toDailyWeatherUIStateList(),
                    location = currentLocation.city
                )
            }
            Log.i("Response : ", state.value.toString())
        }
    }
}