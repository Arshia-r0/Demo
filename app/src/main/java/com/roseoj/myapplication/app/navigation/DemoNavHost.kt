package com.roseoj.myapplication.app.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.roseoj.myapplication.feature.welcome.auth.AuthScreen
import com.roseoj.myapplication.feature.welcome.onboarding.OnboardingScreen


@Composable
fun DemoNavHost() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = DemoRoutes.OnboardingRoute
    ) {
        composable<DemoRoutes.OnboardingRoute> {
            OnboardingScreen(navController)
        }
        composable<DemoRoutes.AuthRoute> {
            AuthScreen(navController)
        }
    }
}

