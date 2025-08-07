package com.example.weatherapplication.domain.repository

import com.example.weatherapplication.domain.model.Weather

interface WeatherRepository {
    suspend fun getWeather(cityName: String): Weather
}
