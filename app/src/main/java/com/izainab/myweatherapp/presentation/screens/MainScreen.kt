package com.izainab.myweatherapp.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.izainab.myweatherapp.R
import com.izainab.myweatherapp.presentation.composable.LocationContainer
import com.izainab.myweatherapp.presentation.composable.TemperatureSection
import com.izainab.myweatherapp.presentation.composable.TodayWeatherSection
import com.izainab.myweatherapp.presentation.composable.WeatherDetailsSection
import com.izainab.myweatherapp.presentation.composable.WeeklyWeatherSection
import com.izainab.myweatherapp.presentation.composable.getWeatherDetailsList
import com.izainab.myweatherapp.presentation.ui.theme.BackgroundLinearGradient
import com.izainab.myweatherapp.presentation.ui.theme.urbanist_FontFamily
import com.izainab.myweatherapp.presentation.viewmodel.WeatherViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    weatherViewModel: WeatherViewModel = koinViewModel<WeatherViewModel>(),
) {

    weatherViewModel.getWeather()

    val state by weatherViewModel.state.collectAsState()


//    if (state.weatherResponse == null) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundLinearGradient),
        contentAlignment = Alignment.Center
    ) {
        if (state.isLoading) {
            CircularProgressIndicator(
                color = Color(0xFF323232),
            )
        } else if (state.weatherResponse == null) {
            Text(
                text = "Failed to fetch Data",
                color = Color(0xFF323232),
                fontFamily = urbanist_FontFamily,
                fontWeight = FontWeight(500),
                fontSize = 16.sp,
                lineHeight = 20.sp,
                letterSpacing = 0.25.sp
            )
        } else {

            Column(
                modifier = modifier
                    .fillMaxSize()
                    .background(BackgroundLinearGradient)
                    .padding(top = 24.dp)
                    .padding(horizontal = 12.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                LocationContainer(state.weatherResponse!!.city)

                Spacer(modifier = Modifier.height(12.dp))

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(rememberScrollState())
                        .padding(bottom = 24.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Image(
                        painter = painterResource(R.drawable.clear_sky),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.height(200.dp)
                    )
                    Spacer(modifier = Modifier.height(12.dp))

                    TemperatureSection(
                        state.weatherResponse!!.weeklyWeatherInfo[0].temperature2mMax.toString() + state.weatherResponse!!.weatherUnits.temperature2m,
                        state.weatherResponse!!.weeklyWeatherInfo[0].temperature2mMin.toString() + state.weatherResponse!!.weatherUnits.temperature2m,
                        state.weatherResponse!!.temperature2m.toString() + state.weatherResponse!!.weatherUnits.temperature2m,
                        "Sunny"
                    )

                    Spacer(modifier = Modifier.height(24.dp))
                    val detailsList = getWeatherDetailsList(
                        windValueWithUnit = state.weatherResponse!!.windSpeed10m.toString() + " " + state.weatherResponse!!.weatherUnits.windSpeed10m,
                        humidityValueWithUnit = state.weatherResponse!!.relativeHumidity2m.toString() + state.weatherResponse!!.weatherUnits.relativeHumidity2m,
                        rainValueWithUnit = state.weatherResponse!!.rain.toString() + state.weatherResponse!!.weatherUnits.rain,
                        uvIndexValueWithUnit = state.weatherResponse!!.uvIndex.toString() + state.weatherResponse!!.weatherUnits.uvIndex,
                        pressureValueWithUnit = state.weatherResponse!!.surfacePressure.toString() + " " + state.weatherResponse!!.weatherUnits.surfacePressure,
                        temperatureValueWithUnit = state.weatherResponse!!.temperature2m.toString() + state.weatherResponse!!.weatherUnits.temperature2m,
                    )
                    WeatherDetailsSection(detailsList)

                    Spacer(modifier = Modifier.height(24.dp))

                    TodayWeatherSection(state.weatherResponse!!)

                    Spacer(modifier = Modifier.height(24.dp))
                    WeeklyWeatherSection(state.weatherResponse!!.weeklyWeatherInfo)
                }
            }
        }
    }
}

@Preview(widthDp = 360, heightDp = 1522)
@Composable
fun MainScreenPre() {
    MainScreen()
}