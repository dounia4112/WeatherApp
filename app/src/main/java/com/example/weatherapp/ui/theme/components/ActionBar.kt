package com.example.weatherapp.ui.theme.components


import android.media.tv.TvContract
import android.widget.ProgressBar
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.BlendModeColorFilter
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.weatherapp.R
import com.example.weatherapp.ui.theme.ColorGradient1
import com.example.weatherapp.ui.theme.ColorGradient2
import com.example.weatherapp.ui.theme.ColorGradient3
import com.example.weatherapp.ui.theme.ColorImageShadow
import com.example.weatherapp.ui.theme.ColorSurface
import com.example.weatherapp.ui.theme.ColorTextPrimary
import com.example.weatherapp.ui.theme.ColorTextPrimaryVariant
import com.example.weatherapp.ui.theme.ColorTextSecondaryVariant
import java.nio.file.WatchEvent

@Composable
fun ActionBar(modifier: Modifier = Modifier) {
    Row (
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ){
        ControlButton()
        LocationInfo(
            modifier = Modifier.padding(top = 10.dp)
        )
        ProfileButton()
    }
}


@Composable
fun ControlButton(modifier: Modifier = Modifier) {
    Surface(
        modifier = Modifier
            .size(48.dp)
            .customShadow(
                color = Color.Black,
                alpha = 0.15f,
                shadowRadius = 16.dp,
                borderRadius = 48.dp,
                offsetY = 4.dp
            ),
        color = ColorSurface,
        shape = CircleShape
    ) {
        // to help align the image cuz surface can't align its content
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ){
            Image(
                painter = painterResource(R.drawable.ic_control),
                contentDescription = null,
                modifier = Modifier.size(20.dp)
            )
        }
    }
}


@Composable
private fun ProfileButton(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = Modifier
            .size(48.dp)
            .border(
                width = 1.5.dp,
                color = ColorSurface,
                shape = CircleShape
            )
            .customShadow(
                color = ColorImageShadow,
                alpha = 0.7f,
                shadowRadius = 12.dp,
                borderRadius = 48.dp,
                offsetY = 6.dp
            )
    ){
        Image(
            painter = painterResource(R.drawable.img_profile),
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize()
                // to create a circle shape
                .clip(CircleShape)
        )
    }
}


@Composable
private fun LocationInfo(
    modifier: Modifier = Modifier,
    location: String = "Algeria"
) {
    Column (
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ){
        Row (
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ){
            Image(
                painter = painterResource(R.drawable.ic_location_pin),
                contentDescription = null,
                contentScale = ContentScale.FillHeight,
                modifier = Modifier.height(18.dp)
            )
            Text(
                text = location,
                style = MaterialTheme.typography.titleLarge,
                color = ColorTextPrimary,
                fontWeight = FontWeight.Bold
            )
        }
        ProgressBar()
    }
}


@Composable
private fun ProgressBar(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .background(
                brush = Brush.linearGradient(
                    0f to ColorGradient1,
                    0.25f to ColorGradient2,
                    1f to ColorGradient3
                ),
                shape = RoundedCornerShape(8.dp)
            )
            .padding(
                vertical = 2.dp,
                horizontal = 10.dp
            )
    ){
        Text(
            text = "Updating ",
            style = MaterialTheme.typography.labelSmall,
            color = ColorTextSecondaryVariant
        )
    }
}




















