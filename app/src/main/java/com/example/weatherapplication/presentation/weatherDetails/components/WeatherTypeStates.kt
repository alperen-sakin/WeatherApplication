package com.example.weatherapplication.presentation.weatherDetails.components

import androidx.annotation.DrawableRes
import com.example.weatherapplication.R

sealed class WeatherTypeStates(
    @DrawableRes val background: Int,
) {
    data object SunnyDay : WeatherTypeStates(R.drawable.background_sunny)
    data object SunnyNight : WeatherTypeStates(R.drawable.background_night)
    data object CloudyDay : WeatherTypeStates(R.drawable.background_cloudy)
    data object RainyDay : WeatherTypeStates(R.drawable.background_rainy)

    companion object {
        fun fromWeatherTypeCode(weatherTypeCode: Int, isDay: Int): WeatherTypeStates {
            return when (weatherTypeCode) {
                SUNNY_CODE -> if (isDay == 1) SunnyDay else SunnyNight
                in RAINY_CODES -> RainyDay

                in CLOUDY_CODE -> CloudyDay
                else -> throw IllegalArgumentException("Unknown weather type code: $weatherTypeCode")
            }
        }

        private const val SUNNY_CODE = 1000
        private val RAINY_CODES = listOf(
            1063,
            1150,
            1153,
            1180,
            1183,
            1186,
            1189,
            1192,
            1195,
            1198,
            1201,
            1240,
            1243,
            1246,
            1273,
            1276
        )
        private val CLOUDY_CODE = listOf(1003, 1006, 1009, 1030)
    }
}
