package com.dara.fitnessapp.ui.screens


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dara.fitnessapp.R
import com.dara.fitnessapp.ui.composables.*
import com.dara.fitnessapp.ui.theme.BluePrimary
import com.dara.fitnessapp.ui.theme.BlueSecondary
import com.dara.fitnessapp.ui.composables.CustomGradientButton

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun SignupScreen() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp, 0.dp)
            .verticalScroll(state = rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CustomText(text = stringResource(id = R.string.hey_here), paddingTop = 30.dp)

        CustomText(
            text = stringResource(R.string.create_an_account),
            textSize = 20.sp,
            textWeight = FontWeight.Bold,
            paddingBottom = 30.dp
        )
        CustomTextField(
            label = stringResource(R.string.first_name)
        )
        CustomTextField(
            label = stringResource(R.string.last_name)
        )
        CustomTextField(
            label = stringResource(R.string.email),
            drawableRes = R.drawable.ic_message,
            contentDescription = stringResource(R.string.email_icon)
        )
        CustomPasswordTextField()

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            CustomCheckBox()

            CustomText(
                text = stringResource(R.string.privacy_policy),
                textColor = colorResource(id = R.color.grey_secondary),
                textSize = 12.sp,
                paddingStart = 10.dp
            )
        }

        Spacer(modifier = Modifier.padding(48.dp))

        CustomGradientButton(
            text = "Register",
            textColor = Color.White,
            gradient = Brush.horizontalGradient(
                colors = listOf(
                    BlueSecondary,
                    BluePrimary
                )
            )
        ) {

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
            CustomText(text = "Already have an account?")
            CustomText(
                text = "Login",
                paddingStart = 4.dp,
                textColor = colorResource(id = R.color.pink_secondary)
            )
        }

    }
}