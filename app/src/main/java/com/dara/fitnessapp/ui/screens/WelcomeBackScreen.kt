package com.dara.fitnessapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.dara.fitnessapp.R
import com.dara.fitnessapp.ui.composables.CustomGradientButton
import com.dara.fitnessapp.ui.composables.CustomText
import com.dara.fitnessapp.ui.theme.BluePrimary
import com.dara.fitnessapp.ui.theme.BlueSecondary
import com.dara.fitnessapp.utils.Constants

@Composable
fun WelcomeBackScreen(
    navController: NavController
) {
    Column(
        modifier = Modifier.fillMaxSize(),
    ) {

        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .weight(5f)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.padding(24.dp))

                Image(
                    painter =
                    painterResource(id = R.drawable.welcome_back_img),
                    contentDescription = stringResource(R.string.welcome_back)
                )

                Spacer(modifier = Modifier.padding(8.dp))

                CustomText(
                    text = stringResource(R.string.welcome_stefani),
                    textSize = 20.sp,
                    textWeight = FontWeight.Bold,
                    paddingBottom = 8.dp
                )

                Text(
                    text = stringResource(R.string.welcome_back_desc),
                    color = colorResource(id = R.color.grey_primary),
                    textAlign = TextAlign.Center,
                    fontSize = 16.sp
                )
            }
        }

        Surface(modifier = Modifier
            .fillMaxWidth()
            .weight(2f)) {}

        Surface(modifier = Modifier
            .fillMaxWidth()
            .weight(1f)) {

            Column() {
                CustomGradientButton(
                    text = stringResource(R.string.go_to_home),
                    textColor = Color.White,
                    gradient = Brush.horizontalGradient(
                        colors = listOf(
                            BlueSecondary,
                            BluePrimary
                        )
                    ),
                    paddingHorizontal = 24.dp
                ) {
                    navController.navigate(Constants.CALORIE_ROUTE)
                }

                Spacer(modifier = Modifier.padding(8.dp))

            }
        }
    }
}