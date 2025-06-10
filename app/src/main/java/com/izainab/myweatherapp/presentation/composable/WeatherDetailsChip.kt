package com.izainab.myweatherapp.presentation.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
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
import com.izainab.myweatherapp.presentation.ui.theme.urbanist_FontFamily

@Composable
fun WeatherDetailsChip(
    title: String,
    value: String,
    painter: Painter,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .height(115.dp)
            .background(Color(0xB2FFFFFF), shape = RoundedCornerShape(24.dp))
            .border(width = 1.dp, color = Color(0x14060414), shape = RoundedCornerShape(24.dp))
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painter,
            contentDescription = null,
            modifier = Modifier.size(32.dp)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = value,
//            color = MaterialTheme.colorScheme.onPrimary,
            color = Color(0xDE060414),
            fontFamily = urbanist_FontFamily,
            fontWeight = FontWeight(500),
            fontSize = 20.sp,
            letterSpacing = 0.25.sp
        )
        Spacer(modifier = Modifier.height(2.dp))
        Text(
            text = title,
//            color = MaterialTheme.colorScheme.onSecondary,
            color = Color(0x99060414),
            fontFamily = urbanist_FontFamily,
            fontWeight = FontWeight(400),
            fontSize = 14.sp,
            letterSpacing = 0.25.sp
        )
    }
}

@Preview
@Composable
fun WeatherDetailsChipPre() {
    WeatherDetailsChip(detailsList[0].title,detailsList[0].value,  painterResource(detailsList[0].imageId))
}