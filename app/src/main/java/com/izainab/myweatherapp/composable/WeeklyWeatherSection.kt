package com.izainab.myweatherapp.composable

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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.izainab.myweatherapp.R
import com.izainab.myweatherapp.ui.theme.urbanist_FontFamily

@Composable
fun WeeklyWeatherSection(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
//            .padding(12.dp)
    ) {
        Text(
            text = "Next 7 days",
            color = Color(0xFF060414),
            fontFamily = urbanist_FontFamily,
            fontWeight = FontWeight(600),
            fontSize = 20.sp,
            letterSpacing = 0.25.sp
        )
        Spacer(modifier = Modifier.height(12.dp))
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(min = 100.dp, max = 1000.dp)
                .background(Color(0xB2FFFFFF), shape = RoundedCornerShape(24.dp))
                .border(width = 1.dp, Color(0x14060414), shape = RoundedCornerShape(24.dp))
                .padding(vertical = 4.dp),
        ) {
            val myList = listOf("", "", "", "", "", "", "")
            itemsIndexed(myList) { index, step ->
                Box(contentAlignment = Alignment.BottomCenter) {

                    DailyWeatherContainer(
                        "Sunday",
                        "32",
                        "20",
                        painterResource(R.drawable.clear_sky)
                    )
                    if (index != myList.lastIndex) {
                        HorizontalDivider(
                            color = Color(0x14060414)
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
    WeeklyWeatherSection()
}