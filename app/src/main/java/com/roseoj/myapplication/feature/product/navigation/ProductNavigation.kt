package com.roseoj.myapplication.feature.product.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.roseoj.myapplication.app.navigation.DemoRoutes
import com.roseoj.myapplication.feature.product.ProductScreen


fun NavGraphBuilder.productNavigation(
    navigateBack: () -> Unit,
) {
    composable<DemoRoutes.ProductRoute> {
        ProductScreen(
            navigateBack = navigateBack
        )
    }
}