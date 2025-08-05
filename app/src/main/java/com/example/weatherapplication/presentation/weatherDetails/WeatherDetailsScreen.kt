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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weatherapplication.R
import com.example.weatherapplication.domain.model.Weather
import com.example.weatherapplication.presentation.weatherDetails.components.WeatherTypeStates

@Composable
fun WeatherDetailsScreen(
    modifier: Modifier = Modifier,
    weather: Weather
) {
    Box(
        modifier = modifier.fillMaxSize()
    ) {
        val weatherTypeState = WeatherTypeStates.fromWeatherTypeCode(
            weatherTypeCode = weather.weatherTypeCode,
            isDay = weather.isDay
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
            Text(
                text = stringResource(R.string.temperature, weather.temperature.toInt()),
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

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                WeatherInfoItem(
                    weather = weather,
                    title = stringResource(R.string.cloudiness),
                    value = stringResource(R.string.percent, weather.cloudiness)
                )

                WeatherInfoItem(
                    weather = weather,
                    title = stringResource(R.string.humidity),
                    value = stringResource(R.string.percent, weather.humidity)
                )

                WeatherInfoItem(
                    weather = weather,
                    title = stringResource(R.string.uv_index),
                    value = weather.uvIndex.toString()
                )
            }
        }
    }
}

@Preview
@Composable
fun WeatherDetailsScreenPreview() {
    WeatherDetailsScreen(
        weather = Weather(
            temperature = 32.0,
            weatherType = "Sunny",
            cloudiness = 2,
            humidity = 55,
            uvIndex = 1.49,
            isDay = 1,
            weatherTypeCode = 1000
        )
    )
}
