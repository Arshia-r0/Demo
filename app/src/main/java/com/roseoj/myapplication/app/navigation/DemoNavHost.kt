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
import com.roseoj.myapplication.app.DemoAppState
import com.roseoj.myapplication.core.designsystem.component.MainScaffold
import com.roseoj.myapplication.feature.main.cart.CartScreen
import com.roseoj.myapplication.feature.main.home.HomeScreen
import com.roseoj.myapplication.feature.main.order.OrderScreen
import com.roseoj.myapplication.feature.main.profile.ProfileScreen
import com.roseoj.myapplication.feature.main.search.SearchScreen
import com.roseoj.myapplication.feature.menu.MenuScreen
import com.roseoj.myapplication.feature.product.ProductScreen
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
            ) { ip ->
                when (currentDestination) {
                    TopLevelDestinations.Home -> HomeScreen(
                        ip = ip,
                        toMenuScreen = {
                            navController.navigate(DemoRoutes.MenuRoute)
                        }
                    )
                    TopLevelDestinations.Search -> SearchScreen(
                        ip = ip,
                    )
                    TopLevelDestinations.Cart -> CartScreen(
                        ip = ip,
                    )
                    TopLevelDestinations.Order -> OrderScreen(
                        ip = ip,
                    )
                    TopLevelDestinations.Profile -> ProfileScreen(
                        ip = ip,
                    )
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
        composable<DemoRoutes.MenuRoute> {
            MenuScreen(
                backAction = {
                    navController.navigateUp()
                },
                toProductScreen = {
                    navController.navigate(DemoRoutes.ProductRoute)
                }
            )
        }
        composable<DemoRoutes.ProductRoute> {
            ProductScreen(
                backAction = {
                    navController.navigateUp()
                }
            )
        }
    }
}
