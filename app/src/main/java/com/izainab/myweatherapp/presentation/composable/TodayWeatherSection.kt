package com.izainab.myweatherapp.presentation.composable

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.izainab.myweatherapp.presentation.states.HourlyWeatherUIState
import com.izainab.myweatherapp.presentation.states.WeatherUnitsUIState
import com.izainab.myweatherapp.presentation.ui.theme.NightPrimaryTextColor
import com.izainab.myweatherapp.presentation.ui.theme.PrimaryTextColor
import com.izainab.myweatherapp.presentation.ui.theme.urbanist_FontFamily
import com.izainab.myweatherapp.presentation.util.WeatherResources
import com.izainab.myweatherapp.presentation.util.convertToHourMinute

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun TodayWeatherSection(
    hourlyWeatherUIStateList: List<HourlyWeatherUIState>,
    weatherUnitsUIState: WeatherUnitsUIState,
    isDay: Boolean,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
    ) {
        Text(
            text = "Today",
            color = if (isDay) PrimaryTextColor else NightPrimaryTextColor,
            fontFamily = urbanist_FontFamily,
            fontWeight = FontWeight(600),
            fontSize = 20.sp,
            letterSpacing = 0.25.sp,
            modifier = Modifier.padding(horizontal = 12.dp)
        )
        SpacerVertical12()
        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(min = 100.dp, max = 1000.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            contentPadding = PaddingValues(horizontal = 12.dp),
        ) {

            items (hourlyWeatherUIStateList) { hourlyItem ->
                HourlyWeatherChip(hourlyItem, weatherUnitsUIState, isDay)
            }
        }
    }
}

@Preview(widthDp = 360)
@Composable
fun TodayWeatherSectionPre() {
//    TodayWeatherSection()
}