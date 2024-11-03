package com.roseoj.myapplication.feature.menu.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.roseoj.myapplication.app.navigation.DemoRoutes
import com.roseoj.myapplication.core.model.product.FoodDetails
import com.roseoj.myapplication.feature.menu.MenuScreen


fun NavGraphBuilder.menuNavigation(
    navigateBack: () -> Unit,
    toProductScreen: (FoodDetails) -> Unit,
) {
    composable<DemoRoutes.MenuRoute> {
        MenuScreen(
            tab = it.toRoute<DemoRoutes.MenuRoute>().tab,
            navigateBack = navigateBack,
            toProductScreen = toProductScreen
        )
    }
}