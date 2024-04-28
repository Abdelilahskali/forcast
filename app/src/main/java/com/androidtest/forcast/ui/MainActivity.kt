package com.androidtest.forcast.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.androidtest.forcast.data.network.remote.Resource
import com.androidtest.forcast.data.response.ForecastResponse
import com.androidtest.forcast.ui.theme.ForcastTheme
import com.androidtest.forcast.ui.forecast.ForecastViewModel
import androidx.lifecycle.viewmodel.compose.viewModel

class MainActivity : ComponentActivity() {
    private val forecastViewModel: ForecastViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ForcastTheme {
                MainScreen(forecastViewModel)
            }
        }
    }
}

@Composable
fun MainScreen(viewModel: ForecastViewModel = viewModel()) {
    // Fetch forecast data when the screen is initially displayed
    viewModel.getForecast("Casablanca")
    // Observe forecast data from the ViewModel
    val forecastResponse by viewModel.forecastResponse.observeAsState()

    // Display the forecast data or loading indicator based on the current state
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        when (forecastResponse) {
            is Resource.Loading -> {
                // Display loading indicator
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator()
                }
            }
            is Resource.Success -> {
                // Display forecast data
                ForecastList((forecastResponse as Resource.Success<ForecastResponse>).value)
            }
            is Resource.Failure -> {
                // Display error message
                Text(text = "Error fetching forecast data")
            }
            else -> {
                // Handle other states if needed
            }
        }
    }
}
@Composable
fun ForecastList(forecastResponse: ForecastResponse) {
    // Display the forecast data in a list
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        forecastResponse.timelines?.daily?.forEach { dailyTimeline ->
            Text(text = "Time: ${dailyTimeline.time ?: "N/A"}")
            Text(text = "Temperature: ${dailyTimeline.values.temperatureAvg ?: "N/A"}")
            Text(text = "Humidity: ${dailyTimeline.values.humidityAvg ?: "N/A"}")
            // Add other forecast data fields as needed
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ForcastTheme {
        MainScreen()
    }
}
