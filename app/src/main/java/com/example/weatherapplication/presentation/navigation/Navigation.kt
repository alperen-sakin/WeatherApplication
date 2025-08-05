package com.example.weatherapplication.presentation.navigation

import HomeScreen
import WeatherDetailsScreen
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.weatherapplication.domain.model.Weather

@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "home_screen") {
        composable("home_screen") {
            HomeScreen(navController = navController)
        }
        composable("weather_details_screen/{cityName}") { backStackEntry ->
            val cityName = backStackEntry.arguments?.getString("cityName")
            if (cityName != null) {
                val weather = Weather(
                    temperature = 32.0,
                    weatherType = "Sunny",
                    cloudiness = 2,
                    humidity = 55,
                    uvIndex = 1.49,
                    isDay = 0,
                    weatherTypeCode = 1000
                )
                WeatherDetailsScreen(
                    weather = weather,
                )
            } else { HomeScreen(navController = navController) }
        }
    }
}
