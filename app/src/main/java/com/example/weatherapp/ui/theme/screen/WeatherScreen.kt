package com.example.weatherapp.ui.theme.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.weatherapp.ui.theme.ColorBackground
import com.example.weatherapp.ui.theme.components.ActionBar
import com.example.weatherapp.ui.theme.components.DailyForecast

@Composable
fun WeatherScreen() {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = ColorBackground
    ) { innerpadding ->
        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(innerpadding)
                .padding(
                    horizontal = 24.dp,
                    vertical = 10.dp
                )
        ){
            ActionBar()
            Spacer(
                modifier = Modifier.height(12.dp)
            )
            DailyForecast()
        }
    }
}