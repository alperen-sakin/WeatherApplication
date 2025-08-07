package com.example.weatherapplication.presentation.weatherDetails.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapplication.domain.model.Weather
import com.example.weatherapplication.domain.repository.WeatherRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeatherDetailsViewModel @Inject constructor(
    private val weatherRepository: WeatherRepository
) : ViewModel() {

    private val _weatherState = MutableStateFlow<Weather?>(null)
    val weatherState: StateFlow<Weather?> = _weatherState

    fun fetchWeather(cityName: String) {
        viewModelScope.launch {
            val result = weatherRepository.getWeather(cityName)
            _weatherState.value = result
        }
    }
}
