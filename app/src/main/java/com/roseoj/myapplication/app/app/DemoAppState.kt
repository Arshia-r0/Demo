package com.roseoj.myapplication.app.app

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.roseoj.myapplication.app.navigation.TopLevelDestination
import com.roseoj.myapplication.core.designsystem.component.navigateToCart
import com.roseoj.myapplication.core.designsystem.component.navigateToHome
import com.roseoj.myapplication.core.designsystem.component.navigateToOrder
import com.roseoj.myapplication.core.designsystem.component.navigateToProfile
import com.roseoj.myapplication.core.designsystem.component.navigateToSearch
import kotlinx.coroutines.CoroutineScope


@Composable
fun rememberDemoAppState(
    coroutineScope: CoroutineScope = rememberCoroutineScope(),
    navController: NavHostController = rememberNavController()
): DemoAppState {
    return remember(
        navController,
        coroutineScope,
    ) {
        DemoAppState(
            navController = navController,
            coroutineScope = coroutineScope,
        )
    }
}

@Stable
class DemoAppState(
    val navController: NavHostController,
    coroutineScope: CoroutineScope,
) {

    val currentDestination: NavDestination?
        @Composable get() = navController.currentBackStackEntryAsState().value?.destination
    
    val currentTopLevelDestination: TopLevelDestination?
        @Composable get() {
            return TopLevelDestination.entries.firstOrNull { topLevelDestination ->
                currentDestination?.hasRoute(route = topLevelDestination.route) ?: false
            }
        }
    
    
    fun navigateToTopLevelDestination(topLevelDestination: TopLevelDestination) {
        when (topLevelDestination) {
            TopLevelDestination.HOME -> navController.navigateToHome()
            TopLevelDestination.SEARCH -> navController.navigateToSearch()
            TopLevelDestination.CART -> navController.navigateToCart()
            TopLevelDestination.ORDER -> navController.navigateToOrder()
            TopLevelDestination.PROFILE -> navController.navigateToProfile()
        }
    }
}
