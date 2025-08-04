import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weatherapplication.R
import com.example.weatherapplication.domain.model.Weather

@Composable
fun WeatherDetailsScreen(
    modifier: Modifier = Modifier,
    weather: Weather
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(top = 116.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = stringResource(R.string.temperature, weather.temperature.toInt()),
            fontSize = 50.sp,
            fontWeight = FontWeight.Medium
        )
        Spacer(Modifier.height(8.dp))
        Text(
            text = weather.weatherType,
            fontSize = 25.sp,
            fontWeight = FontWeight.Medium
        )
        Spacer(Modifier.height(80.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            WeatherInfoItem(
                title = stringResource(R.string.cloudiness),
                value = stringResource(R.string.percent, weather.cloudiness)
            )

            WeatherInfoItem(
                title = stringResource(R.string.humidity),
                value = stringResource(R.string.percent, weather.humidity)
            )

            WeatherInfoItem(
                title = stringResource(R.string.uv_index),
                value = weather.uvIndex.toString()
            )
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
            cloudiness = 23,
            humidity = 31,
            uvIndex = 1.2,
            isDay = 1,
            weatherTypeCode = 1000
        )
    )
}
