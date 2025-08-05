@file:OptIn(ExperimentalMaterial3Api::class)

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.weatherapplication.R
import com.example.weatherapplication.presentation.citySelection.components.CityScreen
import com.example.weatherapplication.presentation.citySelection.components.cities

@Composable
fun HomeScreen(
    navController: NavHostController
) {
    Box {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(R.drawable.main_background),
            contentDescription = "Background",
            contentScale = ContentScale.FillBounds
        )
        Scaffold(
            containerColor = Color.Transparent,
            topBar = {
                TopAppBar(
                    modifier = Modifier.padding(horizontal = 8.dp),
                    title = {
                        Text(
                            text = "Select a city",
                            color = Color.White,
                            fontSize = 24.sp,
                        )
                    },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = Color.Transparent
                    )
                )
            }

        ) { innerPadding ->
            Box(
                modifier = Modifier.fillMaxSize()
                    .padding(innerPadding)
            ) {
                CityScreen(
                    cities = cities,
                    navController = navController
                )
            }
        }
    }
}

@Preview
@Composable
fun HomePreview() {
    val navController = rememberNavController()
    HomeScreen(navController)
}
