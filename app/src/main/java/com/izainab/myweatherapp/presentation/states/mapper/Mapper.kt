package com.izainab.myweatherapp.presentation.states.mapper

import android.os.Build
import androidx.annotation.RequiresApi
import com.izainab.myweatherapp.domain.entities.DailyWeatherInfo
import com.izainab.myweatherapp.domain.entities.HourlyWeatherInfo
import com.izainab.myweatherapp.domain.entities.WeatherInfo
import com.izainab.myweatherapp.domain.entities.WeatherUnits
import com.izainab.myweatherapp.presentation.states.CurrentWeatherUIState
import com.izainab.myweatherapp.presentation.states.DailyWeatherUIState
import com.izainab.myweatherapp.presentation.states.HourlyWeatherUIState
import com.izainab.myweatherapp.presentation.states.WeatherUnitsUIState

 fun List<DailyWeatherInfo>.toDailyWeatherUIStateList(): List<DailyWeatherUIState> {
    return this.map {
        DailyWeatherUIState(
            time = it.time.toString(),
            weatherCode = it.weatherCode,
            temperature2mMin = it.temperature2mMin,
            temperature2mMax = it.temperature2mMax,
        )
    }
}

@RequiresApi(Build.VERSION_CODES.O)
 fun List<HourlyWeatherInfo>.toHourlyWeatherUIStateList(): List<HourlyWeatherUIState> {
    return this.map {
        HourlyWeatherUIState(
            temperature2m = it.temperature2m,
            time = it.time.toString(),
            weatherCode = it.weatherCode,
            isDay = it.isDay
        )
    }
}

 fun WeatherInfo.toCurrentWeatherUIState(): CurrentWeatherUIState {
    return CurrentWeatherUIState(
        rain = this.rain,
        relativeHumidity2m = this.relativeHumidity2m,
        temperature2m = this.temperature2m,
        uvIndex = this.uvIndex,
        surfacePressure = this.surfacePressure,
        windSpeed10m = this.windSpeed10m,
        time = this.time,
        weatherCode = this.weatherCode,
        isDay = this.isDay,
        temperature2mMin = this.weeklyWeatherInfo[0].temperature2mMin,
        temperature2mMax = this.weeklyWeatherInfo[0].temperature2mMax
    )
}

 fun WeatherUnits.weatherUnitsUIState(): WeatherUnitsUIState {
    return WeatherUnitsUIState(
        rain = this.rain,
        relativeHumidity2m = this.relativeHumidity2m,
        temperature2m = this.temperature2m,
        uvIndex = this.uvIndex,
        surfacePressure = this.surfacePressure,
        windSpeed10m = this.windSpeed10m,
        time = this.time
    )
}