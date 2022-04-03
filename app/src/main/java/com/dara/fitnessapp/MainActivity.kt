package com.dara.fitnessapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.dara.fitnessapp.ui.screens.LoginScreen
import com.dara.fitnessapp.ui.screens.OnboardingScreen
import com.dara.fitnessapp.ui.screens.ProfileRegistrationScreen
import com.dara.fitnessapp.ui.screens.WelcomeBackScreen
import com.dara.fitnessapp.ui.theme.FitnessAppTheme
import com.dara.fitnessapp.utils.Constants

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            FitnessAppTheme {
                val navController = rememberNavController()
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    NavHost(
                        navController = navController,
                        startDestination = Constants.ONBOARDING_ROUTE
                    ) {
                        composable(Constants.ONBOARDING_ROUTE) { OnboardingScreen(navController) }
                        composable(Constants.REGISTRATION_ROUTE) { ProfileRegistrationScreen(navController) }
                        composable(Constants.LOG_IN_ROUTE) { LoginScreen(navController)}
                        composable(Constants.WELCOME_BACK_ROUTE) { WelcomeBackScreen()}
                    }
                }
            }
        }
    }

}