package com.izainab.myweatherapp.presentation.util

import com.izainab.myweatherapp.R

object WeatherResources {

    fun getWeatherStatement(weatherCode: Int): String {
        return when (weatherCode) {
            CLEAR_SKY -> "Clear sky"
            MAINLY_CLEAR -> "Mainly clear"
            PARTLY_CLOUDY -> "Partly cloudy"
            OVERCAST -> "Overcast"
            FOG -> "Fog"
            DEPOSITING_RIME_FOG -> "Depositing rime fog"
            LIGHT_DRIZZLE -> "Drizzle light"
            MODERATE_DRIZZLE -> "Drizzle moderate"
            DENSE_INTENSITY_DRIZZLE -> "Drizzle intensity"
            LIGHT_FREEZING_DRIZZLE -> "Freezing drizzle light"
            DENSE_INTENSITY_FREEZING_DRIZZLE -> "Freezing drizzle intensity"
            SLIGHT_RAIN -> "Rain slight"
            MODERATE_RAIN -> "Rain moderate"
            HEAVY_INTENSITY_RAIN -> "Rain intensity"
            LIGHT_FREEZING_RAIN -> "Freezing rain light"
            HEAVY_INTENSITY_FREEZING_RAIN -> "Freezing rain heavy"
            SLIGHT_SNOW_FALL -> "Snow fall light"
            MODERATE_SNOW_FALL -> "Snow fall moderate"
            HEAVY_INTENSITY_SNOW_FALL -> "Snow fal _heavy"
            SNOW_GRAINS -> "Snow grains"
            SLIGHT_RAIN_SHOWERS -> "Rain shower light"
            MODERATE_RAIN_SHOWERS -> "Rain shower moderate"
            VIOLENT_RAIN_SHOWERS -> "Rain shower violent"
            SLIGHT_SNOW_SHOWERS -> "Snow shower slight"
            HEAVY_SNOW_SHOWERS -> "Snow shower heavy"
            SLIGHT_THUNDERSTORM -> "Thunderstorm slight"
            SLIGHT_HAIL_THUNDERSTORM -> "Thunderstorm with slight hail"
            HEAVY_HAIL_THUNDERSTORM -> "Thunderstorm with heavy hail"
            else -> R.drawable.clear_sky
        }.toString()
    }

    fun getImageResId(isDay: Boolean, weatherCode: Int): Int {
        return if (isDay) getDayWeatherImage(weatherCode)
        else getNightWeatherImage(weatherCode)
    }

    private fun getDayWeatherImage(weatherCode: Int): Int {
        return when (weatherCode) {
            CLEAR_SKY -> R.drawable.clear_sky
            MAINLY_CLEAR -> R.drawable.mainly_clear
            PARTLY_CLOUDY -> R.drawable.partly_cloudy
            OVERCAST -> R.drawable.overcast
            FOG -> R.drawable.fog
            DEPOSITING_RIME_FOG -> R.drawable.depositing_rime_fog
            LIGHT_DRIZZLE -> R.drawable.drizzle_light
            MODERATE_DRIZZLE -> R.drawable.drizzle_moderate
            DENSE_INTENSITY_DRIZZLE -> R.drawable.drizzle_intensity
            LIGHT_FREEZING_DRIZZLE -> R.drawable.freezing_drizzle_light
            DENSE_INTENSITY_FREEZING_DRIZZLE -> R.drawable.freezing_drizzle_intensity
            SLIGHT_RAIN -> R.drawable.rain_slight
            MODERATE_RAIN -> R.drawable.rain_moderate
            HEAVY_INTENSITY_RAIN -> R.drawable.rain_intensity
            LIGHT_FREEZING_RAIN -> R.drawable.freezing_rain_light
            HEAVY_INTENSITY_FREEZING_RAIN -> R.drawable.freezing_rain_heavy
            SLIGHT_SNOW_FALL -> R.drawable.snow_fall_light
            MODERATE_SNOW_FALL -> R.drawable.snow_fall_moderate
            HEAVY_INTENSITY_SNOW_FALL -> R.drawable.snow_fall_heavy
            SNOW_GRAINS -> R.drawable.snow_grains
            SLIGHT_RAIN_SHOWERS -> R.drawable.rain_shower_light
            MODERATE_RAIN_SHOWERS -> R.drawable.rain_shower_moderate
            VIOLENT_RAIN_SHOWERS -> R.drawable.rain_shower_violent
            SLIGHT_SNOW_SHOWERS -> R.drawable.snow_shower_slight
            HEAVY_SNOW_SHOWERS -> R.drawable.snow_shower_heavy
            SLIGHT_THUNDERSTORM -> R.drawable.thunderstorm_slight
            SLIGHT_HAIL_THUNDERSTORM -> R.drawable.thunderstorm_with_slight_hail
            HEAVY_HAIL_THUNDERSTORM -> R.drawable.thunderstrom_with_heavy_hail
            else -> R.drawable.clear_sky
        }
    }

    private fun getNightWeatherImage(weatherCode: Int): Int {
        return when (weatherCode) {
            CLEAR_SKY -> R.drawable.clear_sky_night
            MAINLY_CLEAR -> R.drawable.mainly_clear_night
            PARTLY_CLOUDY -> R.drawable.partly_cloudy_night
            OVERCAST -> R.drawable.overcast_night
            FOG -> R.drawable.fog_night
            DEPOSITING_RIME_FOG -> R.drawable.depositing_rime_fog_night
            LIGHT_DRIZZLE -> R.drawable.drizzle_light_night
            MODERATE_DRIZZLE -> R.drawable.drizzle_moderate_night
            DENSE_INTENSITY_DRIZZLE -> R.drawable.drizzle_intensity_night
            LIGHT_FREEZING_DRIZZLE -> R.drawable.freezing_drizzle_light_night
            DENSE_INTENSITY_FREEZING_DRIZZLE -> R.drawable.freezing_drizzle_intensity_night
            SLIGHT_RAIN -> R.drawable.rain_slight_night
            MODERATE_RAIN -> R.drawable.rain_moderate_night
            HEAVY_INTENSITY_RAIN -> R.drawable.rain_intensity_night
            LIGHT_FREEZING_RAIN -> R.drawable.freezing_rain_light_night
            HEAVY_INTENSITY_FREEZING_RAIN -> R.drawable.freezing_rain_heavy_night
            SLIGHT_SNOW_FALL -> R.drawable.snow_fall_light_night
            MODERATE_SNOW_FALL -> R.drawable.snow_fall_moderate_night
            HEAVY_INTENSITY_SNOW_FALL -> R.drawable.snow_fall_heavy_night
            SNOW_GRAINS -> R.drawable.snow_grains_night
            SLIGHT_RAIN_SHOWERS -> R.drawable.rain_shower_light_night
            MODERATE_RAIN_SHOWERS -> R.drawable.rain_shower_moderate_night
            VIOLENT_RAIN_SHOWERS -> R.drawable.rain_shower_violent_night
            SLIGHT_SNOW_SHOWERS -> R.drawable.snow_shower_slight_night
            HEAVY_SNOW_SHOWERS -> R.drawable.snow_shower_heavy_night
            SLIGHT_THUNDERSTORM -> R.drawable.thunderstorm_slight_night
            SLIGHT_HAIL_THUNDERSTORM -> R.drawable.thunderstorm_with_slight_hail_night
            HEAVY_HAIL_THUNDERSTORM -> R.drawable.thunderstrom_with_heavy_hail_night
            else -> R.drawable.clear_sky_night
        }
    }

    private const val CLEAR_SKY = 0
    private const val MAINLY_CLEAR = 1
    private const val PARTLY_CLOUDY = 2
    private const val OVERCAST = 3
    private const val FOG = 45
    private const val DEPOSITING_RIME_FOG = 48
    private const val LIGHT_DRIZZLE = 51
    private const val MODERATE_DRIZZLE = 53
    private const val DENSE_INTENSITY_DRIZZLE = 55
    private const val LIGHT_FREEZING_DRIZZLE = 56
    private const val DENSE_INTENSITY_FREEZING_DRIZZLE = 57
    private const val SLIGHT_RAIN = 61
    private const val MODERATE_RAIN = 63
    private const val HEAVY_INTENSITY_RAIN = 65
    private const val LIGHT_FREEZING_RAIN = 66
    private const val HEAVY_INTENSITY_FREEZING_RAIN = 67
    private const val SLIGHT_SNOW_FALL = 71
    private const val MODERATE_SNOW_FALL = 73
    private const val HEAVY_INTENSITY_SNOW_FALL = 75
    private const val SNOW_GRAINS = 77
    private const val SLIGHT_RAIN_SHOWERS = 80
    private const val MODERATE_RAIN_SHOWERS = 81
    private const val VIOLENT_RAIN_SHOWERS = 82
    private const val SLIGHT_SNOW_SHOWERS = 85
    private const val HEAVY_SNOW_SHOWERS = 86
    private const val SLIGHT_THUNDERSTORM = 95
    private const val SLIGHT_HAIL_THUNDERSTORM = 96
    private const val HEAVY_HAIL_THUNDERSTORM = 99
}