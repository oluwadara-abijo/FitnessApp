package com.dara.fitnessapp.ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.dara.fitnessapp.ui.theme.PinkPrimary
import com.dara.fitnessapp.ui.theme.PinkSecondary
import com.dara.fitnessapp.ui.theme.Shapes

@ExperimentalMaterialApi
@Composable
fun CustomGradientSurface(
    height: Dp = 48.dp,
    width: Dp = 48.dp,
    text: String,
    textColor: Color,
    gradient: Brush,
    onClick: () -> Unit
){

    Surface(
        onClick = { onClick() },
        modifier = Modifier
            .height(height)
            .width(width)
        ,
        shape = Shapes.medium,
        color = Color.Transparent
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(gradient)
                .padding(4.dp, 4.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = text,
                color = textColor,
                fontWeight = FontWeight.Medium
            )
        }
    }
}

@Preview
@ExperimentalMaterialApi
@Composable
fun CustomGradientSurfacePreview() {
    CustomGradientSurface(text = "KG",
        textColor = Color.White,
        gradient = Brush.horizontalGradient(
            colors = listOf(
                PinkPrimary,
                PinkSecondary
            )
        )) {}
}