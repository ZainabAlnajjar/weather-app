package com.izainab.myweatherapp.presentation.composable

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.izainab.myweatherapp.presentation.states.DailyWeatherUIState
import com.izainab.myweatherapp.presentation.ui.theme.BorderColor
import com.izainab.myweatherapp.presentation.ui.theme.CardSurface
import com.izainab.myweatherapp.presentation.ui.theme.NightBorderColor
import com.izainab.myweatherapp.presentation.ui.theme.NightCardSurface
import com.izainab.myweatherapp.presentation.ui.theme.NightPrimaryTextColor
import com.izainab.myweatherapp.presentation.ui.theme.PrimaryTextColor
import com.izainab.myweatherapp.presentation.ui.theme.urbanist_FontFamily
import com.izainab.myweatherapp.presentation.util.WeatherResources
import com.izainab.myweatherapp.presentation.util.convertToDayOfTheWeek

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun WeeklyWeatherSection(
    weeklyWeatherUIState: List<DailyWeatherUIState>,
    isDay: Boolean,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
//            .padding(12.dp)
    ) {
        Text(
            text = "Next 7 days",
            color = if (isDay) PrimaryTextColor else NightPrimaryTextColor,
            fontFamily = urbanist_FontFamily,
            fontWeight = FontWeight(600),
            fontSize = 20.sp,
            letterSpacing = 0.25.sp
        )
        SpacerVertical12()
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(min = 100.dp, max = 1000.dp)
                .background(
                    color = if (isDay) CardSurface else NightCardSurface,
                    shape = RoundedCornerShape(24.dp)
                )
                .border(
                    width = 1.dp,
                    color = if (isDay) BorderColor else NightBorderColor,
                    shape = RoundedCornerShape(24.dp)
                )
                .padding(vertical = 4.dp),
        ) {
            itemsIndexed(weeklyWeatherUIState) { index, day ->
                Box(contentAlignment = Alignment.BottomCenter) {

                    DailyWeatherContainer(
                        convertToDayOfTheWeek(day.time),
                        day.temperature2mMax.toString(),
                        day.temperature2mMin.toString(),
                        painterResource(WeatherResources.getImageResId(true, day.weatherCode)),
                        isDay
                    )
                    if (index != weeklyWeatherUIState.lastIndex) {
                        HorizontalDivider(
                            color = if (isDay) BorderColor else NightBorderColor,
                        )
                    }
                }
            }
        }
    }
}

@Preview(widthDp = 360)
@Composable
fun WeeklyWeatherSectionPre() {
//    WeeklyWeatherSection()
}