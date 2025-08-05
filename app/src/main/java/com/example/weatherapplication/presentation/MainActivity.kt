@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.weatherapplication.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.ExperimentalMaterial3Api
import com.example.weatherapplication.presentation.navigation.Navigation
import com.example.weatherapplication.ui.theme.WeatherApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            WeatherApplicationTheme {
                Navigation()
            }
        }
    }
}
