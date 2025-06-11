package com.izainab.myweatherapp.data.meteoAPIDataSource.mapper

import android.os.Build
import androidx.annotation.RequiresApi
import com.izainab.myweatherapp.data.meteoAPIDataSource.dto.CurrentUnitsDto
import com.izainab.myweatherapp.data.meteoAPIDataSource.dto.DailyDto
import com.izainab.myweatherapp.data.meteoAPIDataSource.dto.HourlyDto
import com.izainab.myweatherapp.data.meteoAPIDataSource.dto.WeatherResponseDto
import com.izainab.myweatherapp.domain.entities.DailyWeatherInfo
import com.izainab.myweatherapp.domain.entities.HourlyWeatherInfo
import com.izainab.myweatherapp.domain.entities.WeatherInfo
import com.izainab.myweatherapp.domain.entities.WeatherUnits
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter


@RequiresApi(Build.VERSION_CODES.O)
fun WeatherResponseDto.toWeatherResponse(): WeatherInfo {
    return WeatherInfo(
        time = this.current.time,
        temperature2m = this.current.temperature2m.toInt(),
        relativeHumidity2m = this.current.relativeHumidity2m.toInt(),
        uvIndex = this.current.uvIndex.toInt(),
        rain = this.current.rain.toInt(),
        surfacePressure = this.current.surfacePressure.toInt(),
        windSpeed10m = this.current.windSpeed10m.toInt(),
        weatherCode = this.current.weatherCode,
        isDay = this.current.isDay == 1,
        todayHourlyWeatherInfo = this.hourly.toTodayHourlyWeatherInfo(),
        weeklyWeatherInfo = this.daily.toWeeklyWeatherInfo(),
        weatherUnits = this.currentUnits.toWeatherUnits(),
    )
}

fun CurrentUnitsDto.toWeatherUnits(): WeatherUnits {
    return WeatherUnits(
        time = this.time,
        temperature2m = this.temperature2m,
        relativeHumidity2m = this.relativeHumidity2m,
        uvIndex = this.uvIndex,
        rain = this.rain,
        weatherCode = this.weatherCode,
        surfacePressure = this.surfacePressure,
        windSpeed10m = this.windSpeed10m,
    )
}

@RequiresApi(Build.VERSION_CODES.O)
fun HourlyDto.toTodayHourlyWeatherInfo(): List<HourlyWeatherInfo> {
    return this.time.mapIndexed { index, time ->
        HourlyWeatherInfo(
            time = LocalDateTime.parse(time, DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm")),
            temperature2m = this.temperature2m[index].toInt(),
            weatherCode = this.weatherCode[index],
            isDay = this.isDay[index] == 1,
        )
    }.filter { hour ->
        hour.time.hour >= LocalDateTime.now().hour && hour.time.toLocalDate() == LocalDateTime.now()
            .toLocalDate()
    }
}

fun DailyDto.toWeeklyWeatherInfo(): List<DailyWeatherInfo> {
    return this.time.mapIndexed { index, time ->
        DailyWeatherInfo(
            time = time,
            temperature2mMin = this.temperature2mMin[index].toInt(),
            temperature2mMax = this.temperature2mMax[index].toInt(),
            weatherCode = this.weatherCode[index]
        )
    }.takeLast(7)
}