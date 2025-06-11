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
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.izainab.myweatherapp.presentation.ui.theme.BorderColor
import com.izainab.myweatherapp.presentation.ui.theme.CardSurface
import com.izainab.myweatherapp.presentation.ui.theme.NightBorderColor
import com.izainab.myweatherapp.presentation.ui.theme.NightCardSurface
import com.izainab.myweatherapp.presentation.ui.theme.NightOpaqueTextColor
import com.izainab.myweatherapp.presentation.ui.theme.NightSecondaryTextColor
import com.izainab.myweatherapp.presentation.ui.theme.OpaqueTextColor
import com.izainab.myweatherapp.presentation.ui.theme.SecondaryTextColor
import com.izainab.myweatherapp.presentation.ui.theme.urbanist_FontFamily

@Composable
fun WeatherDetailsChip(
    title: String,
    value: String,
    painter: Painter,
    isDay: Boolean,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .height(115.dp)
            .background(
                if (isDay) CardSurface else NightCardSurface, shape = RoundedCornerShape(24.dp)
            )
            .border(
                width = 1.dp,
                color = if (isDay) BorderColor else NightBorderColor,
                shape = RoundedCornerShape(24.dp)
            )
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painter,
            contentDescription = null,
            modifier = Modifier.size(32.dp)
        )
        SpacerVertical8()
        Text(
            text = value,
            color = if (isDay) OpaqueTextColor else NightOpaqueTextColor,
            fontFamily = urbanist_FontFamily,
            fontWeight = FontWeight(500),
            fontSize = 20.sp,
            letterSpacing = 0.25.sp
        )
        SpacerVertical2()
        Text(
            text = title,
            color = if (isDay) SecondaryTextColor else NightSecondaryTextColor,
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
    WeatherDetailsChip(
        detailsList[0].title,
        detailsList[0].value,
        painterResource(detailsList[0].imageId),
        true
    )
}