package com.roseoj.myapplication.app.navigation

import kotlinx.serialization.Serializable


sealed interface DemoRoutes {
    @Serializable
    object OnboardingRoute
    @Serializable
    object AuthRoute
    @Serializable
    object MainScreen
}
