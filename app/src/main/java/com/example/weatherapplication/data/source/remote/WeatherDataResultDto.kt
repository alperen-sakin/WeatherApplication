package com.example.weatherapplication.data.source.remote

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class WeatherDataResultDto(
    @Json(name = "current")
    val current: CurrentDto,
    @Json(name = "location")
    val location: LocationDto
)
