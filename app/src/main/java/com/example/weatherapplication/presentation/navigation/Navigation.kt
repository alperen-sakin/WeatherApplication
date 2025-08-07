package com.example.weatherapplication.presentation.navigation

import HomeScreen
import WeatherDetailsScreen
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

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
                WeatherDetailsScreen(
                    cityName = cityName,
                )
            } else { HomeScreen(navController = navController) }
        }
    }
}
