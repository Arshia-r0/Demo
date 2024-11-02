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
import com.roseoj.myapplication.app.DemoAppState
import com.roseoj.myapplication.feature.main.navigation.mainNavigation
import com.roseoj.myapplication.feature.menu.navigation.menuNavigation
import com.roseoj.myapplication.feature.product.navigation.productNavigation
import com.roseoj.myapplication.feature.welcome.navigation.welcomeNavigation


@Composable
fun DemoNavHost(
    appState: DemoAppState,
    isAuthorized: Boolean,
    snackbarHostState: SnackbarHostState = remember { SnackbarHostState() },
    windowAdaptiveInfo: WindowAdaptiveInfo = currentWindowAdaptiveInfo(),
) {
    val navController = appState.navController
    val isOffline by appState.isOffline.collectAsStateWithLifecycle()
    NavHost(
        modifier = Modifier.fillMaxSize(),
        navController = appState.navController,
        startDestination = if (isAuthorized) DemoRoutes.MainRoute else DemoRoutes.WelcomeRoutes
    ) {
        mainNavigation(
            appState = appState,
            isOffline = isOffline,
            snackbarHostState = snackbarHostState,
            windowAdaptiveInfo = windowAdaptiveInfo,
            toMenuScreen = { tab ->
                navController.navigate(DemoRoutes.MenuRoute(tab))
            },
        )
        welcomeNavigation(
            isOffline = isOffline,
            snackbarHostState = snackbarHostState,
            toAuthScreen = {
                navController.navigate(DemoRoutes.WelcomeRoutes.AuthRoute)
            }
        )
        menuNavigation(
            navigateBack = {
                navController.navigateUp()
            },
            toProductScreen = {
                navController.navigate(DemoRoutes.ProductRoute)
            }
        )
        productNavigation(
            navigateBack = {
                navController.navigateUp()
            }
        )
    }
}
