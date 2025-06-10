package com.izainab.myweatherapp.presentation.composable

import com.izainab.myweatherapp.R

val fastWindItem =
    DetailsItem(value = "13 KM/h", title = "Wind", imageId = R.drawable.icon_fast_wind)
val humidityItem =
    DetailsItem(value = "24%", title = "Humidity", imageId = R.drawable.icon_humidity)
val rainItem = DetailsItem(value = "2%", title = "Rain", imageId = R.drawable.icon_rain)
val uvItem = DetailsItem(value = "2", title = "UV Index", imageId = R.drawable.icon_uv)
val pressureItem =
    DetailsItem(value = "1012 hPa", title = "Pressure", imageId = R.drawable.icon_pressure)
val temperatureItem =
    DetailsItem(value = "22°C", title = "Feels like", imageId = R.drawable.icon_temperature)

val detailsList =
    listOf<DetailsItem>(fastWindItem, humidityItem, rainItem, uvItem, pressureItem, temperatureItem)

