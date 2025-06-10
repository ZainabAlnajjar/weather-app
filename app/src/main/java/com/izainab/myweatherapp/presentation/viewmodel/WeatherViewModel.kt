package com.izainab.myweatherapp.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.izainab.myweatherapp.domain.entities.WeatherResponse
import com.izainab.myweatherapp.domain.useCases.GetCurrentLocationWeatherUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

data class WeatherUiState(
    val isLoading: Boolean = false,
    val weatherResponse: WeatherResponse? = null,
    val error: String? = null
)

class WeatherViewModel(
    private val getCurrentLocationWeatherUseCase: GetCurrentLocationWeatherUseCase
) : ViewModel() {

//    init {
//        getWeather()
//    }

    private val _state = MutableStateFlow(WeatherUiState())
    val state = _state.asStateFlow()

    fun getWeather() {
        _state.update { _state.value.copy(isLoading = true) }

        viewModelScope.launch {
            val response = getCurrentLocationWeatherUseCase.getCurrentLocationWeather()

            _state.update { _state.value.copy(weatherResponse = response, isLoading = false) }
            Log.i("Response : ", state.value.toString())
        }
    }
}