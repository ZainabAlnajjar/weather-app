package com.izainab.myweatherapp.presentation.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.izainab.myweatherapp.R
import com.izainab.myweatherapp.presentation.ui.theme.urbanist_FontFamily

@Composable
fun TemperatureSection(
    highTemperature: String,
    lowTemperature: String,
    feelsLikeTemperature: String,
    weatherStatement: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = feelsLikeTemperature,
            color = Color(0xFF060414),
            fontFamily = urbanist_FontFamily,
            fontWeight = FontWeight(600),
            fontSize = 64.sp,
            letterSpacing = 0.25.sp
        )

        Text(
            text = weatherStatement,
            color = Color(0x99060414),
            fontFamily = urbanist_FontFamily,
            fontWeight = FontWeight(500),
            fontSize = 16.sp,
            letterSpacing = 0.25.sp
        )
        Spacer(modifier = Modifier.height(12.dp))
        Row(
            modifier = Modifier
                .background(Color(0x14060414), shape = RoundedCornerShape(100.dp))
                .padding(vertical = 8.dp, horizontal = 24.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Icon(
                    painter = painterResource(R.drawable.icon_arrow_down),
                    contentDescription = null,
                    tint = Color(0x99060414),
                    modifier = Modifier
                        .size(12.dp)
                        .rotate(180f)
                )
                Text(
                    text = highTemperature,
//            color = MaterialTheme.colorScheme.onSecondary,
                    color = Color(0x99060414),
                    fontFamily = urbanist_FontFamily,
                    fontWeight = FontWeight(500),
                    fontSize = 14.sp,
                    letterSpacing = 0.25.sp
                )
            }
            VerticalDivider(
                modifier = Modifier.height(14.dp),
                color = Color(0x3D060414)
            )
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Icon(
                    painter = painterResource(R.drawable.icon_arrow_down),
                    contentDescription = null,
                    tint = Color(0x99060414),
                    modifier = Modifier.size(12.dp)
                )
                Text(
                    text = lowTemperature,
//            color = MaterialTheme.colorScheme.onSecondary,
                    color = Color(0x99060414),
                    fontFamily = urbanist_FontFamily,
                    fontWeight = FontWeight(500),
                    fontSize = 14.sp,
                    letterSpacing = 0.25.sp
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TemperatureSectionPre() {
    TemperatureSection("32°C", "20°C", "24°C", "Partly cloudy")
}