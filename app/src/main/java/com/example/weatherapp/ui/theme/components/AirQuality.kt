package com.example.weatherapp.ui.theme.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weatherapp.R
import androidx.core.content.pm.ShortcutInfoCompat
import com.example.weatherapp.ui.theme.ColorAirQualityIconTitle
import com.example.weatherapp.ui.theme.ColorSurface
import com.example.weatherapp.ui.theme.utils.AirQualityData
import com.example.weatherapp.ui.theme.utils.AirQualityItem

@Composable
fun AirQuality(
    modifier: Modifier = Modifier,
    data: List<AirQualityItem> = AirQualityData
) {
    Surface(
       modifier= Modifier.fillMaxWidth(),
        shape= RoundedCornerShape(32.dp),
        color = ColorSurface
    ){
        Column (
            modifier = Modifier.padding(
                vertical = 18.dp,
                horizontal = 24.dp
            ),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ){
            AirQualityHeader()
        }
    }
}


@Composable
private fun AirQualityHeader(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ){
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ){
            Icon(
                painter = painterResource(R.drawable.ic_air_quality_header),
                contentDescription = null,
                tint = ColorAirQualityIconTitle,
                modifier= Modifier.size(32.dp)
            )

            Text(
                text = "Air Quality",
                style = MaterialTheme.typography.titleMedium.copy(
                    fontSize = 18.sp
                )
            )
        }
    }
}



























