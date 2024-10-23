package com.roseoj.myapplication.feature.welcome

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.roseoj.myapplication.app.app.DemoApp
import com.roseoj.myapplication.feature.welcome.auth.AuthScreen
import com.roseoj.myapplication.feature.welcome.onboarding.OnboardingScreen


@Composable
fun WelcomeNavHost(
    isAuthorized: Boolean
) {
    if(isAuthorized) return DemoApp()
    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) { ip ->
        val navController = rememberNavController()
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
                    navController = navController
                )
            }
        }
    }
}
