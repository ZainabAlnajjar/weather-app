package com.izainab.myweatherapp.presentation.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.lerp
import com.izainab.myweatherapp.presentation.states.CurrentWeatherUIState
import com.izainab.myweatherapp.presentation.states.WeatherUnitsUIState
import com.izainab.myweatherapp.presentation.ui.theme.BlurColor
import com.izainab.myweatherapp.presentation.ui.theme.NightBlurColor
import com.izainab.myweatherapp.presentation.util.WeatherResources
import com.izainab.myweatherapp.presentation.util.dropShadow
import kotlin.math.min

@Composable
fun WeatherSummary(
    city: String,
    isDay: Boolean,
    currentWeatherUIState: CurrentWeatherUIState,
    weatherUnitsUIState: WeatherUnitsUIState,
    scrollState: ScrollState,
    modifier: Modifier = Modifier
) {
    val density = LocalDensity.current
    val scrollStateDp = with(density) { scrollState.value.toDp() }

    var positionState = min(scrollStateDp.value / 212, 1f) // from 0 to 1

    val screenWidth = LocalConfiguration.current.screenWidthDp

    var imageWidthDp by remember { mutableStateOf(0.dp) }
    var temperatureInfoWidthDp by remember { mutableStateOf(0.dp) }

    Column(
        modifier = Modifier
            .fillMaxWidth(),
//            .verticalScroll(scrollState)
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LocationContainer(city, isDay,  modifier = Modifier
            .align(Alignment.CenterHorizontally)
            .padding(
                top = lerp(0.dp, 212.dp, positionState),
                bottom = 12.dp
            )
        )
        Box(
            modifier = modifier
                .fillMaxWidth()
//                .border(width = 1.dp, color = Color.Black)
        ) {

            Image(
                painter = painterResource(
                    WeatherResources.getImageResId(
                        currentWeatherUIState.isDay,
                        currentWeatherUIState.weatherCode
                    )
                ),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .height(lerp(200.dp, 112.dp, positionState))
                    .onGloballyPositioned { coordinates ->
                        imageWidthDp = with(density) { coordinates.size.width.toDp() }
                    }
                    .padding(top = lerp(0.dp, 15.5.dp, positionState))
                    .offset(
//                        x = ((screenWidth - imageWidthDp.value) / 2).dp
                        x = lerp(
                            ((screenWidth - imageWidthDp.value) / 2).dp,
                            12.dp,
                            positionState
                        )
                    ).dropShadow(
                        color = if (isDay) BlurColor else NightBlurColor,
                        blur = 150.dp,
                        scaleY = 0.5f,
                        offsetY = 20.dp
                    )
            )
            SpacerVertical12()

            TemperatureSection(
                currentWeatherUIState.temperature2mMax.toString() + weatherUnitsUIState.temperature2m,
                currentWeatherUIState.temperature2mMin.toString() + weatherUnitsUIState.temperature2m,
                currentWeatherUIState.temperature2m.toString() + weatherUnitsUIState.temperature2m,
                WeatherResources.getWeatherStatement(currentWeatherUIState.weatherCode),
                isDay,
                modifier = Modifier
//                    .padding(top = 212.dp)
                    .padding(top = lerp(212.dp, 0.dp, positionState))
                    .onGloballyPositioned { coordinates ->
                        temperatureInfoWidthDp = with(density) { coordinates.size.width.toDp() }
                    }
                    .offset(
//                        x = ((screenWidth - temperatureInfoWidthDp.value) / 2).dp
                        x = lerp(
                            ((screenWidth - temperatureInfoWidthDp.value) / 2).dp,
                            (screenWidth - temperatureInfoWidthDp.value - 12).dp,
                            positionState
                        )
                    )
            )
        }
    }
}
//
//@Preview(showBackground = true, widthDp = 360, heightDp = 500)
//@Composable
//fun WeatherSummaryPre() {
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .verticalScroll(rememberScrollState())
//    ) {
//
//        WeatherSummary(
//            "Basra",
//            isDay = true,
//            weatherResponse = WeatherResponse(
//                rain = 0,
//                relativeHumidity2m = 0,
//                uvIndex = 0,
//                surfacePressure = 0,
//                temperature2m = 0,
//                windSpeed10m = 0,
//                weatherCode = 0,
//                time = "2025-06-10T12:00",
//                isDay = true,
//                todayHourlyWeatherInfo = emptyList(),
//                weeklyWeatherInfo = listOf(
//                    DailyWeatherInfo(
//                        time = "2025-06-10",
//                        temperature2mMin = 24,
//                        temperature2mMax = 30,
//                        weatherCode = 1
//                    )
//                ),
//                weatherUnits = WeatherUnits(
//                    rain = "%",
//                    relativeHumidity2m = "%",
//                    uvIndex = "uv",
//                    surfacePressure = "%",
//                    temperature2m = "*C",
//                    time = "%",
//                    weatherCode = "%",
//                    windSpeed10m = "%"
//                )
//            ),
//            scrollState = rememberScrollState(),
//        )
//
//        Spacer(modifier = Modifier.height(700.dp))
//    }
//
//}