package com.dara.fitnessapp.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.dara.fitnessapp.R
import com.dara.fitnessapp.ui.composables.*
import com.dara.fitnessapp.ui.theme.BluePrimary
import com.dara.fitnessapp.ui.theme.BlueSecondary
import com.dara.fitnessapp.utils.Constants

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun LoginScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp, 0.dp)
            .verticalScroll(state = rememberScrollState())
    ) {
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .weight(6f)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                CustomText(text = stringResource(id = R.string.hey_here), paddingTop = 30.dp)

                CustomText(
                    text = stringResource(R.string.welcome_back),
                    textSize = 20.sp,
                    textWeight = FontWeight.Bold,
                    paddingBottom = 30.dp
                )

                CustomTextField(
                    label = stringResource(R.string.email),
                    drawableRes = R.drawable.ic_message,
                    contentDescription = stringResource(R.string.email_icon)
                )

                CustomPasswordTextField()

                CustomText(text = "Forgot your password?",
                    textColor = colorResource(id = R.color.grey_primary),
                    textDecoration = TextDecoration.Underline,
                    textWeight = FontWeight.Medium
                ){}
            }
        }

        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .weight(4f)
        ) {}

        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .weight(5f)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                CustomGradientButton(
                    text = "Login",
                    textColor = Color.White,
                    gradient = Brush.horizontalGradient(
                        colors = listOf(
                            BlueSecondary,
                            BluePrimary
                        )
                    )
                ) {
                    navController.navigate(Constants.WELCOME_BACK_ROUTE)
                }

                Row(
                    modifier = Modifier.padding(8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Spacer(
                        modifier = Modifier
                            .weight(1f)
                            .height(1.dp)
                            .background(colorResource(id = R.color.grey_primary))
                    )

                    Text(modifier = Modifier.padding(8.dp), text = "Or")

                    Spacer(
                        modifier = Modifier
                            .weight(1f)
                            .height(1.dp)
                            .background(colorResource(id = R.color.grey_primary))
                    )
                }

                Row {
                    CustomSocialMediaButton(
                        drawableRes = R.drawable.ic_google,
                        contentDescription = "Google Icon",
                        clickAction = {}
                    )

                    Spacer(modifier = Modifier.padding(15.dp))

                    CustomSocialMediaButton(
                        drawableRes = R.drawable.ic_facebook,
                        contentDescription = "Facebook Icon",
                        clickAction = {}
                    )
                }

                Row(modifier = Modifier.padding(0.dp, 24.dp)) {
                    CustomText(text = "Don’t have an account yet?")
                    CustomText(
                        text = "Register",
                        paddingStart = 4.dp,
                        textColor = colorResource(id = R.color.pink_secondary)
                    )
                }

            }

        }

    }
}