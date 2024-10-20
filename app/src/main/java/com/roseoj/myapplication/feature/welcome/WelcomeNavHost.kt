package com.roseoj.myapplication.feature.welcome

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.roseoj.myapplication.feature.welcome.auth.AuthScreen
import com.roseoj.myapplication.feature.welcome.onboarding.OnboardingScreen


@Composable
fun WelcomeNavHost() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = WelcomeRoutes.OnboardingRoute
    ) {
        composable<WelcomeRoutes.OnboardingRoute> {
            OnboardingScreen(navController)
            
        }
        composable<WelcomeRoutes.AuthRoute> {
            AuthScreen(navController)
        }
    }
}