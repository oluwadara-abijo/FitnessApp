package com.dara.fitnessapp.ui.composables

import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dara.fitnessapp.R
import com.dara.fitnessapp.ui.theme.Shapes

@ExperimentalMaterialApi
@Composable
fun CustomSocialMediaButton(
    @DrawableRes
    drawableRes: Int,
    contentDescription: String,
    clickAction: () -> Unit
) {
    Surface(
        onClick = {
            clickAction()
        },
        shape = Shapes.medium,
        border = BorderStroke(width = 1.dp, color = colorResource(id = R.color.grey_primary)),
        color = MaterialTheme.colors.surface
    ) {
        Icon(
            modifier = Modifier.padding(16.dp),
            painter = painterResource(id = drawableRes),
            contentDescription = contentDescription,
            tint = Color.Unspecified
        )
    }
}

@ExperimentalMaterialApi
@Composable
@Preview
fun CustomSocialMediaButtonPreview() {
    CustomSocialMediaButton(
        drawableRes = R.drawable.ic_google,
        contentDescription = "Google Icon",
        clickAction = {}
    )
}