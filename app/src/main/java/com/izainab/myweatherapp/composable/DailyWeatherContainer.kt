package com.izainab.myweatherapp.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.izainab.myweatherapp.R
import com.izainab.myweatherapp.ui.theme.urbanist_FontFamily

@Composable
fun DailyWeatherContainer(
    day: String,
    highTemperature: String,
    lowTemperature: String,
    painter: Painter,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
//            .background(Color(0xB2FFFFFF))
//            .border(width = 0.5.dp, color = Color(0x14060414))
            .padding(horizontal = 16.dp, vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Text(
            text = day,
//            color = MaterialTheme.colorScheme.onPrimary,
            color = Color(0x99060414),
            fontFamily = urbanist_FontFamily,
            fontWeight = FontWeight(400),
            fontSize = 16.sp,
            letterSpacing = 0.25.sp,
            modifier = Modifier.width(91.dp)
        )

        Box(
            modifier = Modifier.size(91.dp, 45.dp),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painter,
                contentDescription = null,
                modifier = Modifier
                    .height(32.dp)
            )
        }


        Row(
            modifier = Modifier,
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {

            Icon(
                painter = painterResource(R.drawable.icon_arrow_down),
                contentDescription = null,
                tint = Color(0xDE060414),
                modifier = Modifier
                    .size(12.dp)
                    .rotate(180f)
            )
            Text(
                text = "$highTemperature°C",
//            color = MaterialTheme.colorScheme.onSecondary,
                color = Color(0xDE060414),
                fontFamily = urbanist_FontFamily,
                fontWeight = FontWeight(500),
                fontSize = 14.sp,
                letterSpacing = 0.25.sp
            )
            Spacer(
                modifier = Modifier
                    .size(1.dp, 14.dp)
                    .border(width = 1.dp, Color(0x3D060414))
            )
            Icon(
                painter = painterResource(R.drawable.icon_arrow_down),
                contentDescription = null,
                tint = Color(0xDE060414),
                modifier = Modifier.size(12.dp)
            )
            Text(
                text = "$lowTemperature°C",
//            color = MaterialTheme.colorScheme.onSecondary,
                color = Color(0xDE060414),
                fontFamily = urbanist_FontFamily,
                fontWeight = FontWeight(500),
                fontSize = 14.sp,
                letterSpacing = 0.25.sp
            )
        }
    }

}


@Preview(widthDp = 360)
@Composable
fun DailyWeatherContainerPre() {
    DailyWeatherContainer(
        "Sunday",
        "32",
        "20",
        painterResource(R.drawable.clear_sky)
    )
}