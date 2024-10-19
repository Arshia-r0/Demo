package com.roseoj.myapplication.app.navigation

import kotlinx.serialization.Serializable


sealed class DemoRoutes {
    @Serializable
    object OnboardingRoute
    @Serializable
    object AuthRoute
}