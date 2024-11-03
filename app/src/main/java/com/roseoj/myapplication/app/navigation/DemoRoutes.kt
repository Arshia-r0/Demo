package com.roseoj.myapplication.app.navigation

import com.roseoj.myapplication.core.model.product.FoodDetails
import com.roseoj.myapplication.feature.menu.components.MenuTabs
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
    
    @Serializable
    data class MenuRoute(
        val tab: MenuTabs,
    )
    
    @Serializable
    data class ProductRoute(
        val food: FoodDetails,
    )
    
}
