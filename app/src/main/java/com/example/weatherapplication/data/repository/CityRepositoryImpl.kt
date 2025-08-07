package com.example.weatherapplication.data.repository

import com.example.weatherapplication.R
import com.example.weatherapplication.domain.model.City
import com.example.weatherapplication.domain.repository.CityRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CityRepositoryImpl @Inject constructor() : CityRepository {
    override fun getCities(): List<City> {
        return listOf(
            City(
                cityImage = R.drawable.agra,
                name = "Agra"
            ),
            City(
                cityImage = R.drawable.barcelona,
                name = "Barcelona"
            ),
            City(
                cityImage = R.drawable.beijing,
                name = "Beijing"
            ),
            City(
                cityImage = R.drawable.sydney,
                name = "Sydney"
            ),
            City(
                cityImage = R.drawable.paris,
                name = "Paris"
            ),
            City(
                cityImage = R.drawable.new_york,
                name = "New york"
            ),
            City(
                cityImage = R.drawable.london,
                name = "London"
            ),
            City(
                cityImage = R.drawable.rio_de_janeiro,
                name = "Rio De Janeiro"
            ),
            City(
                cityImage = R.drawable.moscow,
                name = "Moscow"
            ),
            City(
                cityImage = R.drawable.rome,
                name = "Rome"
            )
        )
    }
}
