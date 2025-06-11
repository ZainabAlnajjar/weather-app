package com.izainab.myweatherapp.presentation.util

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@RequiresApi(Build.VERSION_CODES.O)
fun convertToHourMinute(dateTime: String): String {

    val inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm")
    val outputFormatter = DateTimeFormatter.ofPattern("hh:mm")

    val dateTime = LocalDateTime.parse(dateTime, inputFormatter)
    return dateTime.format(outputFormatter)
}

@RequiresApi(Build.VERSION_CODES.O)
fun convertToDayOfTheWeek(date: String): String {

    val inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")

    val date = LocalDate.parse(date, inputFormatter)
    return date.dayOfWeek.name.lowercase().replaceFirstChar { it.uppercase() }
}


