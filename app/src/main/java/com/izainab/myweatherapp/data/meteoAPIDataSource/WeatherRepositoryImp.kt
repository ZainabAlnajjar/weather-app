package com.izainab.myweatherapp.data.meteoAPIDataSource

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import com.izainab.myweatherapp.data.meteoAPIDataSource.dto.WeatherResponseDto
import com.izainab.myweatherapp.data.meteoAPIDataSource.mapper.toWeatherResponse
import com.izainab.myweatherapp.domain.entities.Location
import com.izainab.myweatherapp.domain.entities.WeatherInfo
import com.izainab.myweatherapp.domain.exceptions.DataFailureException
import com.izainab.myweatherapp.domain.repositories.WeatherRepository
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

class WeatherRepositoryImp : WeatherRepository {

    @RequiresApi(Build.VERSION_CODES.O)
    override suspend fun getWeatherByLocation(location: Location): WeatherInfo {
        return try {
            val client = HttpClient(CIO) {
                install(ContentNegotiation) {
                    json(Json {
                        ignoreUnknownKeys = true
                    })
                }
            }

            val url =
                "https://api.open-meteo.com/v1/forecast?latitude=${location.latitude}&longitude=${location.longitude}&current=temperature_2m,relative_humidity_2m,uv_index,is_day,rain,precipitation_probability,weather_code,surface_pressure,wind_speed_10m&daily=temperature_2m_max,temperature_2m_min,weather_code&hourly=temperature_2m,weather_code,is_day&timezone=auto&forecast_days=8"

             client.get(url).body<WeatherResponseDto>().toWeatherResponse()
                .also { Log.i("Response : ", it.toString()) }

        } catch (_: Exception) {
            throw DataFailureException()
        }
    }
}