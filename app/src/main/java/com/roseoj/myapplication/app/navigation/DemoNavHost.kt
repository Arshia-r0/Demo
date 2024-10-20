package com.roseoj.myapplication.app.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.roseoj.myapplication.app.app.DemoAppState
import com.roseoj.myapplication.feature.main.MainScreen
import com.roseoj.myapplication.feature.welcome.auth.AuthScreen
import com.roseoj.myapplication.feature.welcome.onboarding.OnboardingScreen


@Composable
fun DemoNavHost(
    appState: DemoAppState,
    isAuthorized: Boolean
) {
    NavHost(
        navController = appState.navController,
        startDestination = if(isAuthorized) DemoRoutes.MainScreen
            else DemoRoutes.WelcomeRoute
    ) {
        navigation<DemoRoutes.WelcomeRoute>(startDestination = DemoRoutes.WelcomeRoute.OnboardingRoute) {
            composable<DemoRoutes.WelcomeRoute.OnboardingRoute> {
                OnboardingScreen(appState.navController)
            }
            composable<DemoRoutes.WelcomeRoute.AuthRoute> {
                AuthScreen(appState.navController)
            }
        }
        composable<DemoRoutes.MainScreen> {
            MainScreen(appState.navController)
        }
    }
}
