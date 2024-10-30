package com.roseoj.myapplication.app.navigation

import kotlinx.serialization.Serializable


sealed interface DemoRoutes {
    
    @Serializable
    object MainRoute
    
    @Serializable
    object WelcomeRoutes {
        @Serializable
        object OnboardingRoute
        
        @Serializable
        object AuthRoute
    }
    
}
