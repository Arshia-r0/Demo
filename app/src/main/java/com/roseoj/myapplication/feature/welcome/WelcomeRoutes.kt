package com.roseoj.myapplication.feature.welcome

import kotlinx.serialization.Serializable


sealed interface WelcomeRoutes {
    @Serializable
    object OnboardingRoute
    @Serializable
    object AuthRoute
}