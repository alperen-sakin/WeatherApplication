package com.example.weatherapplication.presentation.citySelection.viewModel

import androidx.lifecycle.ViewModel
import com.example.weatherapplication.domain.repository.CityRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CitySelectionViewModel @Inject constructor(
    private val cityRepository: CityRepository
) : ViewModel() {
    val cities = cityRepository.getCities()
}
