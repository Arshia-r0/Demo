package com.roseoj.myapplication.app.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.roseoj.myapplication.app.MainActivityUiState
import com.roseoj.myapplication.app.ui.DemoAppState
import com.roseoj.myapplication.feature.main.MainScreen
import com.roseoj.myapplication.feature.welcome.auth.AuthScreen
import com.roseoj.myapplication.feature.welcome.onboarding.OnboardingScreen


@Composable
fun DemoNavHost(
    appState: DemoAppState,
    uiState: MainActivityUiState.Success,
    ip: PaddingValues,
//    onShowSnackbar: suspend (String, String?) -> Boolean
) {
    NavHost(
        navController = appState.navController,
        modifier = Modifier.fillMaxSize().padding(ip),
        startDestination = if(!uiState.data.authToken) DemoRoutes.OnboardingRoute
            else DemoRoutes.MainScreen
    ) {
        composable<DemoRoutes.OnboardingRoute> {
            OnboardingScreen(appState.navController)
        }
        composable<DemoRoutes.AuthRoute> {
            AuthScreen(appState.navController)
        }
        composable<DemoRoutes.MainScreen> {
            MainScreen()
        }
    }
}
