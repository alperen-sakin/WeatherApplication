import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.weatherapplication.R
import com.example.weatherapplication.domain.model.Weather
import com.example.weatherapplication.presentation.weatherDetails.components.WeatherTypeStates
import com.example.weatherapplication.presentation.weatherDetails.viewModel.WeatherDetailsViewModel

@Composable
fun WeatherDetailsScreen(
    modifier: Modifier = Modifier,
    viewModel: WeatherDetailsViewModel = hiltViewModel(),
    cityName: String
) {
    val weather by viewModel.weatherState.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.fetchWeather(cityName = cityName)
    }

    if (weather == null) {
        Loading()
    } else {
        Box(
            modifier = modifier.fillMaxSize()
        ) {
            val weatherTypeState = WeatherTypeStates.fromWeatherTypeCode(
                weatherTypeCode = weather!!.weatherTypeCode,
                isDay = weather!!.isDay
            )

            Image(
                painter = painterResource(id = weatherTypeState.background),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 116.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                TopSide(weather)

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    WeatherInfoItem(
                        weather = weather!!,
                        title = stringResource(R.string.cloudiness),
                        value = stringResource(R.string.percent, weather!!.cloudiness)
                    )

                    WeatherInfoItem(
                        weather = weather!!,
                        title = stringResource(R.string.humidity),
                        value = stringResource(R.string.percent, weather!!.humidity)
                    )

                    WeatherInfoItem(
                        weather = weather!!,
                        title = stringResource(R.string.uv_index),
                        value = weather!!.uvIndex.toString()
                    )
                }
            }
        }
    }
}

@Composable
private fun TopSide(weather: Weather?) {
    Text(
        text = stringResource(R.string.temperature, weather!!.temperature.toInt()),
        fontSize = 50.sp,
        fontWeight = FontWeight.Medium,
        color = if (weather.isDay == 1) Color.Black else Color.White
    )
    Spacer(Modifier.height(8.dp))
    Text(
        text = weather.weatherType,
        fontSize = 25.sp,
        fontWeight = FontWeight.Medium,
        color = if (weather.isDay == 1) Color.Black else Color.White
    )
    Spacer(Modifier.height(80.dp))
}

@Composable
private fun Loading() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Loading....")
    }
}
