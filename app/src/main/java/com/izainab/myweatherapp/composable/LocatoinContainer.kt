package com.izainab.myweatherapp.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
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
fun LocationContainer(city: String, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Icon(
            painter = painterResource(R.drawable.icon_location),
            contentDescription = null,
            tint = Color(0xFF323232),
            modifier = Modifier.size(24.dp)
        )
        Text(
            text = city,
            color = Color(0xFF323232),
            fontFamily = urbanist_FontFamily,
            fontWeight = FontWeight(500),
            fontSize = 16.sp,
            lineHeight = 20.sp,
            letterSpacing = 0.25.sp
        )
    }
}

@Preview
@Composable
fun LocationContainerPre() {
    LocationContainer("Baghdad")
}