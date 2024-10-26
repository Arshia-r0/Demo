package com.roseoj.myapplication.app.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.roseoj.myapplication.app.app.DemoAppState
import com.roseoj.myapplication.feature.cart.CartScreen
import com.roseoj.myapplication.feature.home.HomeScreen
import com.roseoj.myapplication.feature.order.OrderScreen
import com.roseoj.myapplication.feature.profile.ProfileScreen
import com.roseoj.myapplication.feature.search.SearchScreen


@Composable
fun DemoNavHost(
    appState: DemoAppState,
) {
    NavHost(
        modifier = Modifier.fillMaxSize(),
        navController = appState.navController,
        startDestination = DemoRoutes.HomeRoute
    ) {
        composable<DemoRoutes.HomeRoute> {
            HomeScreen(
                appState = appState,
            )
        }
        composable<DemoRoutes.SearchRoute> {
            SearchScreen()
        }
        composable<DemoRoutes.CartRoute> {
            CartScreen()
        }
        composable<DemoRoutes.OrderRoute> {
            OrderScreen()
        }
        composable<DemoRoutes.ProfileRoute> {
            ProfileScreen()
        }
    }
}
