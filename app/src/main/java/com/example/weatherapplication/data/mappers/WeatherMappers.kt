package com.example.weatherapplication.data.mappers

import com.example.weatherapplication.data.source.remote.WeatherDataResultDto
import com.example.weatherapplication.domain.model.Weather

fun WeatherDataResultDto.toWeatherDataMap(): Weather {
    return Weather(
        temperature = this.current.tempC,
        weatherType = this.current.condition.text,
        cloudiness = this.current.cloud,
        humidity = this.current.humidity,
        uvIndex = this.current.uv,
        isDay = this.current.isDay,
        weatherTypeCode = this.current.condition.code
    )
}
