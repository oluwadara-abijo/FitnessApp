package com.dara.fitnessapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.dara.fitnessapp.ui.screens.OnboardingScreen
import com.dara.fitnessapp.ui.screens.ProfileRegistrationScreen
import com.dara.fitnessapp.ui.theme.FitnessAppTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FitnessAppTheme {
                var hasFinishedOnboarding by rememberSaveable { mutableStateOf(false) }

                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    if (hasFinishedOnboarding) ProfileRegistrationScreen()
                    else OnboardingScreen { hasFinishedOnboarding = true }
                }
            }
        }
    }

    companion object {
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    FitnessAppTheme {
        ProfileRegistrationScreen()
    }
}