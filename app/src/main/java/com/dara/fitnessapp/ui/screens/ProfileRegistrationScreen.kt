package com.dara.fitnessapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dara.fitnessapp.R
import com.dara.fitnessapp.ui.composables.*
import com.dara.fitnessapp.ui.theme.BluePrimary
import com.dara.fitnessapp.ui.theme.BlueSecondary
import com.dara.fitnessapp.ui.theme.PinkPrimary
import com.dara.fitnessapp.ui.theme.PinkSecondary


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ProfileRegistrationScreen() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp, 0.dp)
            .verticalScroll(state = rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.profile_section),
            contentDescription = stringResource(R.string.profile_section_description)
        )

        CustomText(
            text = stringResource(R.string.profile_registration_screen_title),
            textSize = 20.sp,
            textWeight = FontWeight.Bold,
            paddingTop = 20.dp
        )

        CustomText(
            text = stringResource(R.string.profile_registration_screen_sub_title),
            textColor = colorResource(id = R.color.grey_secondary),
            textSize = 12.sp,
            paddingTop = 8.dp
        )

        CustomDropDownField(
            label = stringResource(R.string.choose_gender),
            drawableRes = R.drawable.ic_gender
        )

        CustomTextField(
            label = stringResource(R.string.date_of_birth),
            drawableRes = R.drawable.ic_calendar
        )

        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Surface(
                modifier = Modifier.weight(7f)
            ) {
                CustomTextField(
                    label = stringResource(R.string.your_weight),
                    drawableRes = R.drawable.ic_weight_scale
                )
            }

            Spacer(modifier = Modifier.padding(8.dp))

            Surface(
                modifier = Modifier.weight(1.5f)
            ) {
                CustomGradientSurface(
                    text = stringResource(R.string.kg_measurement),
                    textColor = Color.White,
                    gradient = Brush.horizontalGradient(
                        colors = listOf(
                            PinkPrimary,
                            PinkSecondary
                        )
                    )
                ) {}
            }
        }

        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Surface(
                modifier = Modifier.weight(7f)
            ) {
                CustomTextField(
                    label = stringResource(R.string.your_height),
                    drawableRes = R.drawable.ic_swap
                )
            }

            Spacer(modifier = Modifier.padding(8.dp))

            Surface(
                modifier = Modifier.weight(1.5f)
            ) {
                CustomGradientSurface(
                    height = 55.dp,
                    width = 55.dp,
                    text = stringResource(R.string.cm_measurement),
                    textColor = Color.White,
                    gradient = Brush.horizontalGradient(
                        colors = listOf(
                            PinkPrimary,
                            PinkSecondary
                        )
                    )
                ) {}
            }

        }

        Spacer(modifier = Modifier.padding(8.dp))

        CustomGradientButton(
            text = stringResource(R.string.next),
            textColor = Color.White,
            gradient = Brush.horizontalGradient(
                colors = listOf(
                    BlueSecondary,
                    BluePrimary
                )
            )
        ) {
        }

        Spacer(modifier = Modifier.padding(15.dp))
    }
}
