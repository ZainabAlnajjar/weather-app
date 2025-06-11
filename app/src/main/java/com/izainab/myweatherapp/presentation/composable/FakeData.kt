package com.izainab.myweatherapp.presentation.composable

import com.izainab.myweatherapp.R
import com.izainab.myweatherapp.presentation.enities.DetailsItem

fun getWeatherDetailsList(windValueWithUnit: String, humidityValueWithUnit: String, rainValueWithUnit: String, uvIndexValueWithUnit: String, pressureValueWithUnit: String, temperatureValueWithUnit: String): List<DetailsItem> {
val fastWindItem =
    DetailsItem(value = windValueWithUnit, title = "Wind", imageId = R.drawable.icon_fast_wind)
val humidityItem =
    DetailsItem(
        value = humidityValueWithUnit,
        title = "Humidity",
        imageId = R.drawable.icon_humidity
    )
val rainItem =
    DetailsItem(value = rainValueWithUnit, title = "Rain", imageId = R.drawable.icon_rain)
val uvItem =
    DetailsItem(value = uvIndexValueWithUnit, title = "UV Index", imageId = R.drawable.icon_uv)
val pressureItem =
    DetailsItem(
        value = pressureValueWithUnit,
        title = "Pressure",
        imageId = R.drawable.icon_pressure
    )
val temperatureItem =
    DetailsItem(
        value = temperatureValueWithUnit,
        title = "Feels like",
        imageId = R.drawable.icon_temperature
    )
    return listOf<DetailsItem>(fastWindItem, humidityItem, rainItem, uvItem, pressureItem, temperatureItem)
}
val detailsList = getWeatherDetailsList("13 KM/h", "24%", "2%", "2%", "1012 hPa", "22°C")
