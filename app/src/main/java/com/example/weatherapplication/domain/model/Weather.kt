package com.example.weatherapplication.domain.model

data class Weather(
    val temperature: Double,
    val weatherType: String,
    val cloudiness: Int,
    val humidity: Int,
    val uvIndex: Double,
    val isDay: Int,
    val weatherTypeCode: Int
)
