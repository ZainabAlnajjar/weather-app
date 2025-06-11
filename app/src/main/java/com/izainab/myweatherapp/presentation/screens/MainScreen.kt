package com.izainab.myweatherapp.presentation.screens

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.izainab.myweatherapp.presentation.composable.SpacerVertical24
import com.izainab.myweatherapp.presentation.composable.TodayWeatherSection
import com.izainab.myweatherapp.presentation.composable.WeatherDetailsSection
import com.izainab.myweatherapp.presentation.composable.WeatherSummary
import com.izainab.myweatherapp.presentation.composable.WeeklyWeatherSection
import com.izainab.myweatherapp.presentation.composable.getWeatherDetailsList
import com.izainab.myweatherapp.presentation.ui.theme.DayBackgroundLinearGradient
import com.izainab.myweatherapp.presentation.ui.theme.LocationTextColor
import com.izainab.myweatherapp.presentation.ui.theme.NightBackgroundLinearGradient
import com.izainab.myweatherapp.presentation.viewmodel.WeatherViewModel
import org.koin.androidx.compose.koinViewModel

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun MainScreen(
    innerPadding: PaddingValues,
    modifier: Modifier = Modifier,
    weatherViewModel: WeatherViewModel = koinViewModel<WeatherViewModel>(),
) {

    weatherViewModel.getWeather()

    val state by weatherViewModel.state.collectAsState()

    Box(
        modifier = Modifier
            .fillMaxSize(),
//            .background(DayBackgroundLinearGradient),
        contentAlignment = Alignment.Center
    ) {
        if (state.currentWeather == null) {
            CircularProgressIndicator(
                color = LocationTextColor
            )
        } else {

            val isDay = state.currentWeather!!.isDay

            var columnScrollState = rememberScrollState()

            Column(
                modifier = modifier
                    .fillMaxSize()
                    .background(
                        brush = if (isDay) DayBackgroundLinearGradient else NightBackgroundLinearGradient
                    )
                    .padding(innerPadding)
                    .verticalScroll(columnScrollState)
//                    .padding(horizontal = 12.dp)
                    .padding(top = 24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                WeatherSummary(
                    state.location,
                    isDay = isDay,
                    scrollState = columnScrollState,
                    currentWeatherUIState = state.currentWeather!!,
                    weatherUnitsUIState = state.weatherUnitsUIState!!,
                )
//
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(bottom = 24.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    SpacerVertical24()
                    val detailsList = getWeatherDetailsList(
                        windValueWithUnit = state.currentWeather!!.windSpeed10m.toString() + " " + state.weatherUnitsUIState!!.windSpeed10m.slice(
                            0..1
                        ).uppercase() + state.weatherUnitsUIState!!.windSpeed10m.slice(2..3),
                        humidityValueWithUnit = state.currentWeather!!.relativeHumidity2m.toString() + state.weatherUnitsUIState!!.relativeHumidity2m,
                        rainValueWithUnit = state.currentWeather!!.rain.toString() + state.weatherUnitsUIState!!.rain,
                        uvIndexValueWithUnit = state.currentWeather!!.uvIndex.toString() + state.weatherUnitsUIState!!.uvIndex,
                        pressureValueWithUnit = state.currentWeather!!.surfacePressure.toString() + " " + state.weatherUnitsUIState!!.surfacePressure,
                        temperatureValueWithUnit = state.currentWeather!!.temperature2m.toString() + state.weatherUnitsUIState!!.temperature2m,
                    )
                    WeatherDetailsSection(
                        detailsList,
                        isDay,
                        modifier = Modifier.padding(horizontal = 12.dp)
                    )

                    SpacerVertical24()

                    TodayWeatherSection(
                        state.hourlyWeatherUIState,
                        state.weatherUnitsUIState!!, state.currentWeather!!.isDay
                    )

                    SpacerVertical24()
                    WeeklyWeatherSection(
                        state.dailyWeatherUIState,
                        isDay,
                        modifier = Modifier.padding(horizontal = 12.dp)
                    )
                }
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview(widthDp = 360, heightDp = 1522)
@Composable
fun MainScreenPre() {
    MainScreen(PaddingValues())
}