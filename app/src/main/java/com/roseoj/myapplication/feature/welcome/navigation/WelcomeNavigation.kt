package com.roseoj.myapplication.feature.welcome.navigation

import androidx.compose.material3.SnackbarHostState
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.roseoj.myapplication.app.navigation.DemoRoutes
import com.roseoj.myapplication.feature.welcome.auth.AuthScreen
import com.roseoj.myapplication.feature.welcome.onboarding.OnboardingScreen


fun NavGraphBuilder.welcomeNavigation(
    isOffline: Boolean,
    snackbarHostState: SnackbarHostState,
    toAuthScreen: () -> Unit,
) {
    navigation<DemoRoutes.WelcomeRoutes>(
        startDestination = DemoRoutes.WelcomeRoutes.OnboardingRoute
    ) {
        composable<DemoRoutes.WelcomeRoutes.OnboardingRoute> {
            OnboardingScreen(
                toAuthScreen = toAuthScreen
            )
        }
        composable<DemoRoutes.WelcomeRoutes.AuthRoute> {
            AuthScreen(
                isOffline = isOffline,
                snackbarHostState = snackbarHostState,
            )
        }
    }
}