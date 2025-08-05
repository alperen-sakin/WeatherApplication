import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.weatherapplication.domain.model.Weather

@Composable
fun WeatherInfoItem(
    title: String,
    value: String,
    weather: Weather,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Text(
            text = value,
            fontSize = 25.sp,
            fontWeight = FontWeight.Medium,
            color = if (weather.isDay == 1) Color.Black else Color.White,
        )
        Text(
            text = title,
            fontSize = 15.sp,
            fontWeight = FontWeight.Medium,
            color = if (weather.isDay == 1) Color.Black else Color.White
        )
    }
}
