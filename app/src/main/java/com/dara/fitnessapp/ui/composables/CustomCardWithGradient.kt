package com.dara.fitnessapp.ui.composables


import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dara.fitnessapp.ui.theme.BluePrimary
import com.dara.fitnessapp.ui.theme.BlueSecondary
import com.dara.fitnessapp.ui.theme.Shapes

@Composable
fun CustomCardWithGradient(
    goal: String,
    goalDescription: String,
    @DrawableRes
    drawableRes: Int,
    gradient: Brush = Brush.horizontalGradient(
        colors = listOf(
            BlueSecondary,
            BluePrimary
        )
    ),
    onClick: () -> Unit
) {

    Card(
        modifier = Modifier
            .height(478.dp)
            .padding(0.dp, 8.dp)
        ,
        shape = Shapes.large,
        elevation = ButtonDefaults.elevation().elevation(
            enabled = true,
            interactionSource = remember { MutableInteractionSource() }).value,
    ) {
        Box(
            modifier = Modifier
                .background(gradient),
            contentAlignment = Alignment.Center
        ) {

            Column(
                modifier = Modifier.padding(28.dp, 0.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter =
                    painterResource(id = drawableRes),
                    contentDescription = goal
                )

                Spacer(modifier = Modifier.size(24.dp))

                Text(
                    text = goal,
                    color = Color.White,
                    fontWeight = FontWeight.Medium,
                    fontSize = 16.sp
                )

                Surface(
                    modifier = Modifier
                        .width(50.dp)
                        .height(1.dp),
                    color = Color.White
                ) {

                }

                Spacer(modifier = Modifier.size(24.dp))

                Text(
                    text = goalDescription,
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    fontSize = 16.sp
                )
            }

        }
    }


}
