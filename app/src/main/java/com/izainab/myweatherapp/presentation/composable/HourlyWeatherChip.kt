package com.izainab.myweatherapp.presentation.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.izainab.myweatherapp.R
import com.izainab.myweatherapp.presentation.ui.theme.urbanist_FontFamily

@Composable
fun HourlyWeatherChip(
    hour: String,
    temperature: String,
    painter: Painter,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = Modifier
            .height(132.dp)
    ) {
        Column(
            modifier = Modifier
                .size(88.dp, 120.dp).align(Alignment.BottomCenter)
                .background(Color(0xB2FFFFFF), shape = RoundedCornerShape(20.dp))
                .border(width = 1.dp, color = Color(0x14060414), shape = RoundedCornerShape(20.dp))
                .padding(bottom = 16.dp),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = hour,
//            color = MaterialTheme.colorScheme.onPrimary,
                color = Color(0xDE060414),
                fontFamily = urbanist_FontFamily,
                fontWeight = FontWeight(500),
                fontSize = 16.sp,
                letterSpacing = 0.25.sp
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = temperature,
//            color = MaterialTheme.colorScheme.onSecondary,
                color = Color(0x99060414),
                fontFamily = urbanist_FontFamily,
                fontWeight = FontWeight(500),
                fontSize = 16.sp,
                letterSpacing = 0.25.sp
            )
        }
        Image(
            painter = painter,
            contentDescription = null,
//            contentScale = ContentScale.Crop,
            modifier = Modifier
                .height(58.dp)
                .align(Alignment.TopCenter)
        )
    }
}


@Preview
@Composable
fun HourlyWeatherChipPre() {
    HourlyWeatherChip(
        "25°C",
        "11:00",
        painterResource(R.drawable.clear_sky)
    )
}