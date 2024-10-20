package com.roseoj.myapplication.app.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.roseoj.myapplication.app.app.DemoAppState
import com.roseoj.myapplication.feature.main.MainScreen


@Composable
fun DemoNavHost(
    appState: DemoAppState,
) {
    NavHost(
        navController = appState.navController,
        startDestination = DemoRoutes.MainScreen
    ) {
        composable<DemoRoutes.MainScreen> {
            MainScreen()
        }
    }
}
