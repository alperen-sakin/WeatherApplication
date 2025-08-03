package com.example.weatherapplication.domain.model

import androidx.annotation.DrawableRes

data class City(
    @DrawableRes val cityImage: Int,
    val name: String
)
