package com.example.weatherapplication.data.source.remote

import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {

    @GET("v1/current.json")
    suspend fun getWeatherData(
        @Query("key") key: Int,
        @Query("q") cityName: String
    ): WeatherDataResultDto
}
