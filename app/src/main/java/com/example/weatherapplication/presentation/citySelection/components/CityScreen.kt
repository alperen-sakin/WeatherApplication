package com.example.weatherapplication.presentation.citySelection.components
import CityBox
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
import com.example.weatherapplication.R
import com.example.weatherapplication.domain.model.City

val cities = listOf(
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
        name = "sydney"
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
        name = "Moskow"
    ),
    City(
        cityImage = R.drawable.rome,
        name = "Rome"
    ),
)

@Composable
fun CityScreen(
    cities: List<City>
) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = 146.dp),
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(21.dp),
        verticalArrangement = Arrangement.SpaceAround,
        horizontalArrangement = Arrangement.spacedBy(26.dp)

    ) {
        items(cities) { city ->
            CityBox(
                cityImage = city.cityImage
            )
        }
    }
}

@Preview
@Composable
fun CityScreenPreview() {
    CityScreen(
        cities = cities
    )
}
