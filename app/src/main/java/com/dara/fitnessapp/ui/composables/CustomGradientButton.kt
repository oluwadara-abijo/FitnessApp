package com.dara.fitnessapp.ui.composables


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dara.fitnessapp.ui.theme.BluePrimary
import com.dara.fitnessapp.ui.theme.BlueSecondary
import com.dara.fitnessapp.ui.theme.Shapes


@Composable
fun CustomGradientButton(
    text: String,
    textColor: Color,
    gradient: Brush,
    onClick: () -> Unit
) {

    Button(
        onClick = { onClick() },
        modifier = Modifier
            .fillMaxWidth(),
        shape = Shapes.large,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Transparent
        ),
        contentPadding = PaddingValues()
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(gradient)
                .padding(16.dp, 16.dp),
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
@Composable
fun CustomGradientButtonPreview() {
    CustomGradientButton(
        text = "Register",
        textColor = White,
        gradient = Brush.horizontalGradient(
            colors = listOf(
                BlueSecondary,
                BluePrimary
            )
        )
    ) {

    }
}