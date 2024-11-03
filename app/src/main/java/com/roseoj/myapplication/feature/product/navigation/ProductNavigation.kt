package com.roseoj.myapplication.feature.product.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.roseoj.myapplication.app.navigation.DemoNavTypes
import com.roseoj.myapplication.app.navigation.DemoRoutes
import com.roseoj.myapplication.core.model.product.FoodDetails
import com.roseoj.myapplication.feature.product.ProductScreen
import kotlin.reflect.typeOf


fun NavGraphBuilder.productNavigation(
    navigateBack: () -> Unit,
) {
    composable<DemoRoutes.ProductRoute>(
        typeMap = mapOf(
            typeOf<FoodDetails>() to DemoNavTypes.FoodDetailsType
        )
    ) {
        ProductScreen(
            food = it.toRoute<DemoRoutes.ProductRoute>().food,
            navigateBack = navigateBack
        )
    }
}