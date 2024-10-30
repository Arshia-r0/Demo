package com.roseoj.myapplication.app.navigation

import kotlinx.serialization.Serializable


sealed interface DemoRoutes {
    
    @Serializable
    data object MainRoutes {
        
        @Serializable
        object HomeRoute
        
        @Serializable
        object SearchRoute
        
        @Serializable
        object CartRoute
        
        @Serializable
        object OrderRoute
        
        @Serializable
        object ProfileRoute
    }
    
    @Serializable
    data object WelcomeRoutes {
        @Serializable
        object OnboardingRoute
        
        @Serializable
        object AuthRoute
    }
    
}
