package com.example.weatherapplication.domain.repository

import com.example.weatherapplication.domain.model.City

interface CityRepository {
    fun getCities(): List<City>
}
