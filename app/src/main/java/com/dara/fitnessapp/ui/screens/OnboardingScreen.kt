package com.dara.fitnessapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dara.fitnessapp.Onboarding
import com.dara.fitnessapp.R
import com.dara.fitnessapp.ui.theme.GreyText
import com.dara.fitnessapp.ui.theme.PurpleDark
import com.dara.fitnessapp.ui.theme.PurpleLight

@Composable
fun OnboardingScreen(action: () -> Unit) {
    val onboardingScreens = listOf(
        Onboarding(
            R.drawable.ic_track_goal,
            stringResource(R.string.track_your_goal),
            stringResource(R.string.track_your_goal_caption)
        ), Onboarding(
            R.drawable.ic_get_burn,
            stringResource(R.string.get_burn),
            stringResource(R.string.get_burn_caption)
        ), Onboarding(
            R.drawable.ic_eat_well,
            stringResource(R.string.eat_well),
            stringResource(R.string.eat_well_caption)
        ), Onboarding(
            R.drawable.ic_improve_sleep_quality,
            stringResource(R.string.improve_sleep_quality),
            stringResource(R.string.improve_sleep_quality_caption)
        )
    )

    ShowOnboardingScreen(onboardingScreens, action)
}

@Composable
fun ShowOnboardingScreen(screens: List<Onboarding>, action: () -> Unit) {

    var pageCount by remember { mutableStateOf(0) }

    when (pageCount) {
        0 -> SplashScreen(onGetStartedClickedClicked = { pageCount++ })
        1, 2, 3, 4 -> OnboardingSteps(
            onNextClicked = { pageCount++ },
            onboarding = screens[pageCount - 1]
        )
        else -> action.invoke()

    }
}

@Composable
fun SplashScreen(onGetStartedClickedClicked: () -> Unit) {
    Surface {
        Column(
            modifier = Modifier
                .padding(vertical = 48.dp, horizontal = 24.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Column(
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.weight(1f)
            ) {

                Image(
                    painterResource(id = R.drawable.ic_logo_purple),
                    contentDescription = stringResource(R.string.logo)
                )

                Text(
                    text = stringResource(R.string.everybody_can_train),
                    style = MaterialTheme.typography.subtitle1,
                    fontSize = 18.sp,
                    color = GreyText,
                    modifier = Modifier.padding(vertical = 16.dp)
                )
            }

            Button(
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent),
                onClick = onGetStartedClickedClicked,
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(32.dp),
                contentPadding = PaddingValues(),
            ) {
                Box(
                    modifier = Modifier
                        .background(
                            brush = Brush.horizontalGradient(listOf(PurpleLight, PurpleDark))
                        )
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 16.dp),
                    contentAlignment = Alignment.Center

                ) {
                    Text(
                        text = stringResource(R.string.get_started),
                        style = MaterialTheme.typography.subtitle1,
                        fontSize = 18.sp,
                        color = Color.White
                    )
                }
            }
        }
    }
}

@Composable
fun OnboardingSteps(
    onboarding: Onboarding?,
    onNextClicked: () -> Unit
) {
    if (onboarding != null) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
        ) {
            Image(
                painterResource(id = onboarding.imageResource),
                contentDescription = stringResource(R.string.track_your_goal),
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.FillWidth
            )

            Text(
                text = onboarding.primaryText,
                style = MaterialTheme.typography.h2,
                modifier = Modifier.padding(top = 48.dp, start = 32.dp)
            )

            Text(
                text = onboarding.secondaryText,
                style = MaterialTheme.typography.subtitle1,
                fontSize = 18.sp,
                modifier = Modifier.padding(vertical = 16.dp, horizontal = 32.dp)
            )

            Button(
                onClick = onNextClicked,
                modifier = Modifier
                    .padding(end = 32.dp, top = 64.dp)
                    .size(50.dp)
                    .align(Alignment.End),
                shape = RoundedCornerShape(64.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent),
                contentPadding = PaddingValues(),
            ) {
                Box(
                    modifier = Modifier
                        .background(
                            brush = Brush.horizontalGradient(
                                listOf(
                                    PurpleLight,
                                    PurpleDark
                                )
                            )
                        )
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 16.dp),
                    contentAlignment = Alignment.Center

                ) {

                    Image(
                        painterResource(id = R.drawable.ic_baseline_keyboard_arrow_right),
                        contentDescription = stringResource(R.string.next),
                    )
                }
            }

        }
    }
}
