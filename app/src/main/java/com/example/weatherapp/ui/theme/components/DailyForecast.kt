package com.example.weatherapp.ui.theme.components

import android.accessibilityservice.GestureDescription
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester.Companion.createRefs
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.core.net.ParseException
import com.example.weatherapp.R
import com.example.weatherapp.ui.theme.ColorGradient1
import com.example.weatherapp.ui.theme.ColorGradient2
import com.example.weatherapp.ui.theme.ColorGradient3
import com.example.weatherapp.ui.theme.ColorTextPrimaryVariant
import com.example.weatherapp.ui.theme.ColorTextSecondary
import com.example.weatherapp.ui.theme.ColorTextSecondaryVariant
import com.example.weatherapp.ui.theme.ColorWindForecast
import java.nio.file.WatchEvent

@Composable
fun DailyForecast(
    modifier: Modifier = Modifier,
    forecast: String= "Rain showers",
    date: String = "Monday, 12 Feb"
) {
    ConstraintLayout(
        modifier = Modifier.fillMaxWidth()
    ){
        //references that identifies this composable so you can define how it should be positioned relative to other layout elements.
        val (forecastImage, forecastValue, windImage, title, description, background) = createRefs()

        CardBackground(
            //applies constraints to the CardBackground composable
            modifier = Modifier.constrainAs (background){
                linkTo(
                    //parent refers to the ConstraintLayout container that wraps around this composable.
                    start = parent.start,
                    end =parent.end,
                    top= parent.top,
                    bottom = description.bottom,
                    topMargin = 20.dp
                )
                height = Dimension.fillToConstraints
            }
        )


        Image(
            painter = painterResource(R.drawable.img_sub_rain),
            contentDescription = null,
            contentScale = ContentScale.FillHeight,
            modifier = Modifier.constrainAs (forecastImage){
                start.linkTo(anchor = parent.start, margin= 4.dp)
                top.linkTo(anchor = parent.top)
            }
        )

        Text(
            text = forecast,
            style = MaterialTheme.typography.titleLarge,
            color = ColorTextSecondary,
            fontWeight = FontWeight.Medium,
            modifier = Modifier.constrainAs (title){
                start.linkTo(anchor = parent.start, margin = 20.dp)
                top.linkTo(anchor = forecastImage.bottom)
            }
        )

        Text(
            text = date,
            style = MaterialTheme.typography.bodyMedium,
            color = ColorTextSecondaryVariant,
            // date should be referenced to description
            modifier = Modifier
                .constrainAs(description) {
                    start.linkTo(anchor = title.start)
                    top.linkTo(anchor = title.bottom)
                }
                .padding(bottom = 24.dp)
        )

        ForecastValue(
            modifier = Modifier.constrainAs(forecastValue) {
                end.linkTo(anchor = parent.end, margin = 24.dp)
                top.linkTo(forecastImage.top, margin = 20.dp)
                bottom.linkTo(forecastImage.bottom)
            }
        )

        WindForecastImage(
            modifier = Modifier.constrainAs(windImage) {
                linkTo(
                    top= title.top,
                    bottom = title.bottom,
                    topMargin = 28.dp
                )
                end.linkTo(anchor = parent.end, margin = 24.dp)
            }
        )
    }
}


@Composable
private fun CardBackground(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(
                brush = Brush.linearGradient(
                    0f to ColorGradient1,
                    0.5f to ColorGradient2,
                    1f to ColorGradient3
                ),
                shape = RoundedCornerShape(32.dp)
            )
    )
}



@Composable
private fun ForecastValue(
    modifier: Modifier = Modifier,
    degree: String = "21",
    description: String = "Feels like 26°"
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.Start
    ) {
        Box(
            //positions this Text in the top-right corner of the Box
            contentAlignment = Alignment.TopEnd
        ) {
            Text(
                text = degree,
                letterSpacing = 0.sp,
                style = TextStyle(
                    brush = Brush.verticalGradient(
                        0f to Color.White,
                        1f to Color.White.copy(alpha = 0.3f)
                    ),
                    fontSize = 80.sp,
                    fontWeight = FontWeight.Black
                ),
                modifier = Modifier.padding(end = 16.dp)
            )
            Text(
                text = "°",
                style = TextStyle(
                    brush = Brush.verticalGradient(
                        0f to Color.White,
                        1f to Color.White.copy(alpha = 0.3f)
                    ),
                    fontSize = 70.sp,
                    fontWeight = FontWeight.Light,
                ),
                modifier = Modifier.padding(top = 2.dp)
            )
        }
        Text(
            text = description,
            style = MaterialTheme.typography.bodyMedium,
            color = ColorTextSecondaryVariant
        )
    }
}


@Composable
private fun WindForecastImage(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ){
        Icon(
            painter = painterResource(R.drawable.ic_frosty),
            contentDescription = null,
            modifier = Modifier.size(60.dp),
            tint = ColorWindForecast
        )

        Icon(
            painter = painterResource(R.drawable.ic_wind),
            contentDescription = null,
            modifier = Modifier.size(60.dp),
            tint = ColorWindForecast
        )
    }
}

























