package com.dara.fitnessapp.ui.composables


import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.animateIntAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import com.dara.fitnessapp.R
import com.dara.fitnessapp.ui.theme.BluePrimary
import com.dara.fitnessapp.ui.theme.BlueSecondary
import com.dara.fitnessapp.ui.theme.PinkSecondary

@Composable
fun CustomComponent(
    canvasSize: Dp = 300.dp,
    indicatorValue: Int = 0,
    maxIndicatorValue: Int = 760,
    backgroundIndicatorColor: Color = colorResource(id = R.color.ghost_white),
    backgroundIndicationStrokeWidth: Float = 60f,
    foregroundIndicatorColor: Brush = Brush.horizontalGradient(
        colors = listOf(
            BlueSecondary,
            PinkSecondary
        )
    ),
    foregroundIndicationStrokeWidth: Float = 60f,
    bigTextFontSize: TextUnit = MaterialTheme.typography.h3.fontSize,
    bigTextColor: Color = colorResource(id = R.color.white),
    bigTextSuffix: String = "kCal",
    smallText: String = "left",
    smallTextColor: Color = colorResource(id = R.color.white),
    smallTextFontSize: TextUnit = MaterialTheme.typography.h6.fontSize
) {

    var allowedIndicatorValue by remember {
        mutableStateOf(maxIndicatorValue)
    }

    var calorieBalance by remember {
        mutableStateOf(smallText)
    }

    allowedIndicatorValue = if (indicatorValue <= maxIndicatorValue) {
        indicatorValue
    } else {
        maxIndicatorValue
    }

    var animatedIndicatorValue by remember {
        mutableStateOf(0f)
    }

    LaunchedEffect(key1 = allowedIndicatorValue) {
        animatedIndicatorValue = allowedIndicatorValue.toFloat()
    }

    val percentage =
        (animatedIndicatorValue / maxIndicatorValue) * 100

    val sweepAngle by animateFloatAsState(
        targetValue = (3.6 * percentage).toFloat(),
        animationSpec = tween(1000)
    )

    val receivedValue by animateIntAsState(
        targetValue = maxIndicatorValue - allowedIndicatorValue,
        animationSpec = tween(1000)
    )

    calorieBalance = if (receivedValue == 0) {
        "Completed"
    } else {
        smallText
    }

    Column(
        modifier = Modifier
            .size(canvasSize)
            .drawBehind {
                val componentSize = size / 1.25f
                backgroundIndicator(
                    componentSize = componentSize,
                    indicatorColor = backgroundIndicatorColor,
                    indicationStrokeWidth = backgroundIndicationStrokeWidth,
                )

                foregroundIndicator(
                    sweepAngle = sweepAngle,
                    componentSize = componentSize,
                    indicatorColor = foregroundIndicatorColor,
                    indicationStrokeWidth = foregroundIndicationStrokeWidth
                )
            },
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        EmbeddedElements(
            bigText = receivedValue,
            bigTextFontSize = bigTextFontSize,
            bigTextColor = bigTextColor,
            bigTextSuffix = bigTextSuffix,
            smallText = calorieBalance,
            smallTextColor = smallTextColor,
            smallTextFontSize = smallTextFontSize
        )
    }

}

fun DrawScope.backgroundIndicator(
    componentSize: Size,
    indicatorColor: Color,
    indicationStrokeWidth: Float
) {
    drawArc(
        size = componentSize,
        color = indicatorColor,
        startAngle = 80f,
        sweepAngle = 360f,
        useCenter = false,
        style = Stroke(
            width = indicationStrokeWidth,
            cap = StrokeCap.Round
        ),
        topLeft = Offset(
            x = (size.width - componentSize.width) / 2f,
            y = (size.height - componentSize.height) / 2f
        )
    )
}

fun DrawScope.foregroundIndicator(
    sweepAngle: Float,
    componentSize: Size,
    indicatorColor: Brush,
    indicationStrokeWidth: Float
) {
    drawArc(
        size = componentSize,
        brush = indicatorColor,
        startAngle = 80f,
        sweepAngle = sweepAngle,
        useCenter = false,
        style = Stroke(
            width = indicationStrokeWidth,
            cap = StrokeCap.Round
        ),
        topLeft = Offset(
            x = (size.width - componentSize.width) / 2f,
            y = (size.height - componentSize.height) / 2f
        )
    )
}

@Composable
fun EmbeddedElements(
    bigText: Int,
    bigTextFontSize: TextUnit,
    bigTextColor: Color,
    bigTextSuffix: String,
    smallText: String,
    smallTextColor: Color,
    smallTextFontSize: TextUnit
) {

    Surface(
        modifier = Modifier.size(200.dp),
        shape = RoundedCornerShape(100.dp)
    ) {
        Column(
            Modifier.background(
                brush = Brush.horizontalGradient(
                    colors = listOf(
                        BlueSecondary,
                        BluePrimary
                    )
                )
            ),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "$bigText $bigTextSuffix",
                color = bigTextColor,
                fontSize = bigTextFontSize,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Normal
            )

            Text(
                text = smallText,
                color = smallTextColor,
                fontSize = smallTextFontSize,
                textAlign = TextAlign.Center
            )
        }
    }

}