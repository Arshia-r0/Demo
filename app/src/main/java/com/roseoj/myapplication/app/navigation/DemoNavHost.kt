package com.roseoj.myapplication.app.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.adaptive.WindowAdaptiveInfo
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.roseoj.myapplication.app.app.DemoAppState
import com.roseoj.myapplication.core.designsystem.component.MainScaffold
import com.roseoj.myapplication.feature.cart.CartScreen
import com.roseoj.myapplication.feature.home.HomeScreen
import com.roseoj.myapplication.feature.order.OrderScreen
import com.roseoj.myapplication.feature.profile.ProfileScreen
import com.roseoj.myapplication.feature.search.SearchScreen
import com.roseoj.myapplication.feature.welcome.auth.AuthScreen
import com.roseoj.myapplication.feature.welcome.onboarding.OnboardingScreen


@Composable
fun DemoNavHost(
    appState: DemoAppState,
    isAuthorized: Boolean,
    snackbarHostState: SnackbarHostState = remember { SnackbarHostState() },
    windowAdaptiveInfo: WindowAdaptiveInfo = currentWindowAdaptiveInfo(),
) {
    val navController = appState.navController
    val currentDestination by appState.topLevelDestination
    val isOffline by appState.isOffline.collectAsStateWithLifecycle()
    NavHost(
        modifier = Modifier.fillMaxSize(),
        navController = appState.navController,
        startDestination = if (isAuthorized) DemoRoutes.MainRoute else DemoRoutes.WelcomeRoutes
    ) {
        composable<DemoRoutes.MainRoute> {
            MainScaffold(
                appState = appState,
                currentDestination = currentDestination,
                windowAdaptiveInfo = windowAdaptiveInfo,
                isOffline = isOffline,
                snackBarHostState = snackbarHostState,
            ) {
                when (currentDestination) {
                    TopLevelDestinations.Home -> HomeScreen()
                    TopLevelDestinations.Search -> SearchScreen()
                    TopLevelDestinations.Cart -> CartScreen()
                    TopLevelDestinations.Order -> OrderScreen()
                    TopLevelDestinations.Profile -> ProfileScreen()
                }
            }
        }
        navigation<DemoRoutes.WelcomeRoutes>(
            startDestination = DemoRoutes.WelcomeRoutes.OnboardingRoute
        ) {
            composable<DemoRoutes.WelcomeRoutes.OnboardingRoute> {
                OnboardingScreen(
                    nextScreen = {
                        navController.navigate(DemoRoutes.WelcomeRoutes.AuthRoute)
                    }
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
}
