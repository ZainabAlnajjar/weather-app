package com.izainab.myweatherapp.presentation.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.izainab.myweatherapp.R
import com.izainab.myweatherapp.presentation.ui.theme.urbanist_FontFamily

@Composable
fun TodayWeatherSection(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
    ) {
        Text(
            text = "Today",
            color = Color(0xFF060414),
            fontFamily = urbanist_FontFamily,
            fontWeight = FontWeight(600),
            fontSize = 20.sp,
            letterSpacing = 0.25.sp
        )
        Spacer(modifier = Modifier.height(12.dp))
        LazyRow (
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(min = 100.dp, max = 1000.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
//            contentPadding = PaddingValues(bottom = 12.dp),
        ) {
            items  (listOf("", "", "","","","","")) { step ->
                HourlyWeatherChip("25°C", "11:00", painterResource(R.drawable.clear_sky))
            }
        }
    }
}

@Preview(widthDp = 360)
@Composable
fun TodayWeatherSectionPre() {
    TodayWeatherSection()
}