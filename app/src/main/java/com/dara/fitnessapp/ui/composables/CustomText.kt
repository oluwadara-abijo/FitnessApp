package com.dara.fitnessapp.ui.composables

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CustomText(
    text: String,
    textSize: TextUnit = 16.sp,
    textWeight: FontWeight = FontWeight.Normal,
    paddingBottom: Dp = 0.dp,
    paddingStart: Dp = 0.dp,
    paddingTop: Dp = 0.dp,
    paddingEnd: Dp = 0.dp,
    textColor: Color = Color.Black,
    textAlign: TextAlign? = null
) {
    Text(
        modifier = Modifier.padding(paddingStart, paddingTop, paddingEnd, paddingBottom),
        text = text,
        fontSize = textSize,
        fontWeight = textWeight,
        color = textColor,
        textAlign = textAlign
    )
}