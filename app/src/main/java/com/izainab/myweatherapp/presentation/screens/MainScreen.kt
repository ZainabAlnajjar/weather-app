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
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.izainab.myweatherapp.R
import com.izainab.myweatherapp.presentation.composable.LocationContainer
import com.izainab.myweatherapp.presentation.composable.TemperatureSection
import com.izainab.myweatherapp.presentation.composable.TodayWeatherSection
import com.izainab.myweatherapp.presentation.composable.WeatherDetailsSection
import com.izainab.myweatherapp.presentation.composable.WeeklyWeatherSection
import com.izainab.myweatherapp.presentation.ui.theme.BackgroundLinearGradient
import com.izainab.myweatherapp.presentation.viewmodel.WeatherViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    weatherViewModel: WeatherViewModel = koinViewModel<WeatherViewModel>(),
) {

    val state = weatherViewModel.getWeather()
    Box(
        modifier = Modifier.fillMaxSize()
            .background(BackgroundLinearGradient),
        contentAlignment = Alignment.Center
    ) {
        if (state.weatherResponse == null) {
            CircularProgressIndicator(
                color = Color(0xFF323232),
            )
            return
        }

        Column(
            modifier = modifier
                .fillMaxSize()
                .background(BackgroundLinearGradient)
                .padding(top = 24.dp)
                .padding(horizontal = 12.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            LocationContainer("Baghdad")

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

                TemperatureSection("32°C", "20°C", "24°C", "Partly cloudy")

                Spacer(modifier = Modifier.height(24.dp))
                WeatherDetailsSection()

                Spacer(modifier = Modifier.height(24.dp))
                TodayWeatherSection()

                Spacer(modifier = Modifier.height(24.dp))
                WeeklyWeatherSection(state.weatherResponse.weeklyWeatherInfo)
            }
        }
    }
}

@Preview(widthDp = 360, heightDp = 1522)
@Composable
fun MainScreenPre() {
    MainScreen()
}