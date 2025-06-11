package com.izainab.myweatherapp.presentation.composable

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.izainab.myweatherapp.presentation.states.HourlyWeatherUIState
import com.izainab.myweatherapp.presentation.states.WeatherUnitsUIState
import com.izainab.myweatherapp.presentation.ui.theme.BorderColor
import com.izainab.myweatherapp.presentation.ui.theme.CardSurface
import com.izainab.myweatherapp.presentation.ui.theme.NightBorderColor
import com.izainab.myweatherapp.presentation.ui.theme.NightCardSurface
import com.izainab.myweatherapp.presentation.ui.theme.NightOpaqueTextColor
import com.izainab.myweatherapp.presentation.ui.theme.NightSecondaryTextColor
import com.izainab.myweatherapp.presentation.ui.theme.NightSmallBlurColor
import com.izainab.myweatherapp.presentation.ui.theme.OpaqueTextColor
import com.izainab.myweatherapp.presentation.ui.theme.SecondaryTextColor
import com.izainab.myweatherapp.presentation.ui.theme.SmallBlurColor
import com.izainab.myweatherapp.presentation.ui.theme.urbanist_FontFamily
import com.izainab.myweatherapp.presentation.util.WeatherResources
import com.izainab.myweatherapp.presentation.util.convertToHourMinute
import com.izainab.myweatherapp.presentation.util.dropShadow

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun HourlyWeatherChip(
    hourlyWeatherUIState: HourlyWeatherUIState,
    weatherUnitsUIState: WeatherUnitsUIState,
    isDay: Boolean,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = Modifier
            .height(132.dp)
    ) {
        Column(
            modifier = Modifier
                .size(88.dp, 120.dp)
                .align(Alignment.BottomCenter)
                .background(
                    color = if (isDay) CardSurface else NightCardSurface,
                    shape = RoundedCornerShape(20.dp)
                )
                .border(
                    width = 1.dp,
                    color = if (isDay) BorderColor else NightBorderColor,
                    shape = RoundedCornerShape(20.dp)
                )
                .padding(bottom = 16.dp),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = convertToHourMinute(hourlyWeatherUIState.time.toString()),
//            color = MaterialTheme.colorScheme.onPrimary,
                color = if (isDay) OpaqueTextColor else NightOpaqueTextColor,
                fontFamily = urbanist_FontFamily,
                fontWeight = FontWeight(500),
                fontSize = 16.sp,
                letterSpacing = 0.25.sp
            )
            SpacerVertical4()
            Text(
                text = hourlyWeatherUIState.temperature2m.toString() + weatherUnitsUIState.temperature2m,
                color = if (isDay) SecondaryTextColor else NightSecondaryTextColor,

                fontFamily = urbanist_FontFamily,
                fontWeight = FontWeight(500),
                fontSize = 16.sp,
                letterSpacing = 0.25.sp
            )
        }
        Image(
            painter = painterResource(
                WeatherResources.getImageResId(
                    hourlyWeatherUIState.isDay,
                    hourlyWeatherUIState.weatherCode
                ),
            ),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(64.dp, 58.dp)
                .align(Alignment.TopCenter)
                .dropShadow(
                    color = if (hourlyWeatherUIState.isDay && isDay) SmallBlurColor else NightSmallBlurColor,
                    blur = 44.dp,
//                    scaleY = 0.5f,
//                    offsetY = 50.dp
                )
        )
    }
}


@Preview
@Composable
fun HourlyWeatherChipPre() {
//    HourlyWeatherChip(
//        "25°C",
//        "11:00",
//        R.drawable.clear_sky,
//        true
//    )
}