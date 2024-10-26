package com.roseoj.myapplication.feature.welcome

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.roseoj.myapplication.app.app.DemoApp
import com.roseoj.myapplication.core.designsystem.component.DemoSnackbar
import com.roseoj.myapplication.core.network.util.NetworkMonitor
import com.roseoj.myapplication.feature.welcome.auth.AuthScreen
import com.roseoj.myapplication.feature.welcome.onboarding.OnboardingScreen
import kotlinx.coroutines.flow.map


@Composable
fun WelcomeNavHost(
    networkMonitor: NetworkMonitor,
    isAuthorized: Boolean
) {
    if(isAuthorized) return DemoApp(networkMonitor)
    val isOffline by networkMonitor.isOnline.map(Boolean::not).collectAsStateWithLifecycle(initialValue = false)
    val snackbarHostState = remember { SnackbarHostState() }
    val navController = rememberNavController()
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        snackbarHost = {
            SnackbarHost(snackbarHostState) {
                DemoSnackbar(it)
            }
        }
    ) { ip ->
        NavHost(
            modifier = Modifier.fillMaxSize().padding(ip),
            navController = navController,
            startDestination = WelcomeRoutes.OnboardingRoute
        ) {
            composable<WelcomeRoutes.OnboardingRoute> {
                OnboardingScreen(
                    navController = navController
                )
            }
            composable<WelcomeRoutes.AuthRoute> {
                AuthScreen(
                    isOffline = isOffline,
                    snackbarHostState = snackbarHostState,
                    navController = navController
                )
            }
        }
    }
}
