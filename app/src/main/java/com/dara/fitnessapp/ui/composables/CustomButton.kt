package com.dara.fitnessapp.ui.composables

import androidx.annotation.ColorRes
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.dara.fitnessapp.R
import com.dara.fitnessapp.ui.theme.Shapes

@Composable
fun CustomButton(
    @ColorRes
    drawableRes: Int = R.color.blue_primary,
    buttonText: String,
    buttonTextColor: Color = Color.White,
    paddingBottom: Dp = 0.dp,
    paddingStart: Dp = 0.dp,
    paddingTop: Dp = 0.dp,
    paddingEnd: Dp = 0.dp,
    textWeight: FontWeight = FontWeight.Medium,
    clickAction: () -> Unit
) {
    Button(
        onClick = { clickAction },
        modifier = Modifier
            .fillMaxWidth(),
        shape = Shapes.large,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = colorResource(id = drawableRes)
        )
    ) {
        CustomText(
            text = buttonText,
            textColor = buttonTextColor,
            textWeight = textWeight,
            paddingTop = paddingTop,
            paddingBottom = paddingTop
        )

    }
}

@Preview
@Composable
fun CustomButtonPreview() {
    CustomButton(buttonText = "Register") {

    }
}