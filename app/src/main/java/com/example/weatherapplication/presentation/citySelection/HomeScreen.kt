import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.weatherapplication.presentation.citySelection.components.CityScreen
import com.example.weatherapplication.presentation.citySelection.components.cities

@Composable
fun HomeScreen(
    modifier: Modifier
) {
    Box(
        modifier = modifier.fillMaxSize()
    ) {
        CityScreen(cities = cities)
    }
}

@Preview
@Composable
fun HomePreview() {
    HomeScreen(modifier = Modifier)
}
