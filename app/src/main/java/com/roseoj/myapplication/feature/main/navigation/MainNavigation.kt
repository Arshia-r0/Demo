package com.roseoj.myapplication.feature.main.navigation

import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.adaptive.WindowAdaptiveInfo
import androidx.compose.runtime.getValue
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.roseoj.myapplication.app.DemoAppState
import com.roseoj.myapplication.app.navigation.DemoRoutes
import com.roseoj.myapplication.app.navigation.TopLevelDestinations
import com.roseoj.myapplication.core.designsystem.component.MainScaffold
import com.roseoj.myapplication.feature.main.cart.CartScreen
import com.roseoj.myapplication.feature.main.home.HomeScreen
import com.roseoj.myapplication.feature.main.order.OrderScreen
import com.roseoj.myapplication.feature.main.profile.ProfileScreen
import com.roseoj.myapplication.feature.main.search.SearchScreen
import com.roseoj.myapplication.feature.menu.components.MenuTabs


fun NavGraphBuilder.mainNavigation(
    appState: DemoAppState,
    isOffline: Boolean,
    snackbarHostState: SnackbarHostState,
    windowAdaptiveInfo: WindowAdaptiveInfo,
    toMenuScreen: (MenuTabs) -> Unit,
) {
    composable<DemoRoutes.MainRoute> {
        val currentDestination by Destination.currentTopLevelDestination
        MainScaffold(
            appState = appState,
            windowAdaptiveInfo = windowAdaptiveInfo,
            isOffline = isOffline,
            snackBarHostState = snackbarHostState,
            currentDestination = currentDestination
        ) { ip ->
            when (currentDestination) {
                TopLevelDestinations.Home -> HomeScreen(
                    ip = ip,
                    toMenuScreen = toMenuScreen
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
}