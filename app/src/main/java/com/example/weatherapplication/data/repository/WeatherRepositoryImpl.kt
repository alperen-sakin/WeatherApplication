package com.example.weatherapplication.data.repository

import com.example.weatherapplication.data.mappers.toWeatherDataMap
import com.example.weatherapplication.data.source.remote.WeatherApi
import com.example.weatherapplication.domain.model.Weather
import com.example.weatherapplication.domain.repository.WeatherRepository
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val weatherApi: WeatherApi
) : WeatherRepository {
    override suspend fun getWeather(cityName: String): Weather {
        val responseDto = weatherApi.getWeatherData(API_KEY, cityName)
        return responseDto.toWeatherDataMap()
    }

    companion object {
        private const val API_KEY = "2e51b373cb5a4bf982010527250602"
    }
}
