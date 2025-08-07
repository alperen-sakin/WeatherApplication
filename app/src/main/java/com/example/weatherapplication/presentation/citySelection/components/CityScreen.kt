package com.example.weatherapplication.presentation.citySelection.components
import CityBox
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.weatherapplication.presentation.citySelection.viewModel.CitySelectionViewModel

@Composable
fun CityScreen(
    navController: NavHostController,
    viewModel: CitySelectionViewModel = hiltViewModel()
) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = 146.dp),
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(21.dp),
        verticalArrangement = Arrangement.SpaceAround,
        horizontalArrangement = Arrangement.spacedBy(26.dp)

    ) {
        items(viewModel.cities) { city ->
            CityBox(
                cityImage = city.cityImage,
                modifier = Modifier.clickable {
                    navController.navigate("weather_details_screen/${city.name}")
                }
            )
        }
    }
}

@Preview
@Composable
fun CityScreenPreview() {
    val navController = rememberNavController()
    CityScreen(

        navController = navController
    )
}
