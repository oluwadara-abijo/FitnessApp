package com.dara.fitnessapp.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ScaleFactor
import androidx.compose.ui.layout.lerp
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dara.fitnessapp.R
import com.dara.fitnessapp.ui.composables.CustomText
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.calculateCurrentOffsetForPage
import kotlin.math.absoluteValue
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import com.dara.fitnessapp.ui.composables.CustomCardWithGradient
import com.dara.fitnessapp.ui.composables.CustomGradientButton
import com.dara.fitnessapp.ui.theme.BluePrimary
import com.dara.fitnessapp.ui.theme.BlueSecondary
import com.google.accompanist.pager.ExperimentalPagerApi

@OptIn(ExperimentalPagerApi::class)
@Composable
fun GoalsSetUpScreen() {

    Surface(color = MaterialTheme.colors.background) {
        Column(
            modifier = Modifier
                .verticalScroll(state = rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            CustomText(
                text = stringResource(R.string.what_is_your_goal),
                textSize = 20.sp,
                textWeight = FontWeight.Bold,
                paddingTop = 24.dp
            )

            CustomText(
                text = stringResource(R.string.help_choose_best_program),
                textColor = colorResource(id = R.color.grey_secondary),
                textSize = 12.sp,
                paddingTop = 8.dp,
                paddingBottom = 24.dp,
                textAlign = TextAlign.Center
            )

            HorizontalPager(count = 3) { page ->

                Surface(
                    modifier = Modifier
                        .graphicsLayer {
                            val pageOffset = calculateCurrentOffsetForPage(page).absoluteValue

                            lerp(
                                start = ScaleFactor(1f, 0.85f),
                                stop = ScaleFactor(0.85f, 1f),
                                fraction = 1f - pageOffset.coerceIn(0f, 1f)
                            ).also { scale ->
                                scaleX = scale.scaleX
                                scaleY = scale.scaleY
                            }

                        }
                ) {
                    when (page) {
                        0 -> {
                            CustomCardWithGradient(
                                goal = stringResource(R.string.improve_shape),
                                goalDescription = stringResource(R.string.improve_shape_description),
                                drawableRes = R.drawable.goal_improve_shape
                            ) {}
                        }
                        1 -> {
                            CustomCardWithGradient(
                                goal = stringResource(R.string.lean_and_tone),
                                goalDescription = stringResource(R.string.lean_and_tone_description),
                                drawableRes = R.drawable.goal_lean_and_tone
                            ) {}
                        }
                        2 -> {
                            CustomCardWithGradient(
                                goal = stringResource(R.string.lose_a_fat),
                                goalDescription = stringResource(R.string.lose_a_fat_description),
                                drawableRes = R.drawable.goal_lose_a_fat
                            ) {}
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.padding(16.dp))

            CustomGradientButton(
                text = stringResource(R.string.confirm),
                textColor = Color.White,
                gradient = Brush.horizontalGradient(
                    colors = listOf(
                        BlueSecondary,
                        BluePrimary
                    )
                ),
                paddingHorizontal = 24.dp
            ) {}

            Spacer(modifier = Modifier.padding(16.dp))
        }
    }

}