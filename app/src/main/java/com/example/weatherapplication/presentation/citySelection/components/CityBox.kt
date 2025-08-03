import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.weatherapplication.R
import com.example.weatherapplication.ui.theme.cityBackground

@Composable
fun CityBox(
    modifier: Modifier = Modifier,
    cityImage: Int
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(129.dp),
        shape = RoundedCornerShape(15.dp),
        colors = CardDefaults.cardColors(
            containerColor = cityBackground
        )
    ) {
        Box(
            modifier = modifier.fillMaxSize(),
            contentAlignment = Alignment.Center,

        ) {
            Image(
                painter = painterResource(cityImage),
                contentDescription = "City Image",
                contentScale = ContentScale.FillHeight
            )
        }
    }
}

@Preview
@Composable
fun CityBoxPreview() {
    CityBox(
        modifier = Modifier,
        cityImage = R.drawable.rome
    )
}
