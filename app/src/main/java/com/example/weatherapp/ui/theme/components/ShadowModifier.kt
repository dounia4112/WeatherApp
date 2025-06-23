package com.example.weatherapp.ui.theme.components

import androidx.compose.material.ripple.RippleAlpha
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
// extending Modifier with a new function called customShadow,
// to apply a custom drop shadow effect to any Composable.
fun Modifier.customShadow(
    color: Color = Color.Black,
    alpha: Float = 0.5F,
    borderRadius: Dp =0.dp,
    shadowRadius: Dp = 0.dp,
    offsetY : Dp = 0.dp,
    offsetX: Dp = 0.dp
    //Adds a drawing layer behind the content
) =drawBehind {

    val shadowColor = color.copy(alpha=alpha).toArgb()
    val transparent = color.copy(alpha=0f).toArgb()

    // Access the underlying Canvas object for lower-level drawing APIs (Start Drawing on Canvas)
    this.drawIntoCanvas {
        //is used to configure styles.
        val paint = Paint()
        //accesses the underlying Android Paint API.
        val frameworkPaint = paint.asFrameworkPaint()
        frameworkPaint.color = transparent

        //This creates a blurred shadow effect behind the painted shape using native Android paint engine.
        frameworkPaint.setShadowLayer(
            shadowRadius.toPx(),  // blur radius
            offsetX.toPx(),       // horizontal shift
            offsetY.toPx(),       // vertical shift
            shadowColor           // shadow color
        )

        //Draws a rounded rectangle the size of the Composable, with the shadow effect applied.
        it.drawRoundRect(
            0f,
            0f,
            this.size.width,
            this.size.height,
            borderRadius.toPx(),
            borderRadius.toPx(),
            paint
        )
    }
}

