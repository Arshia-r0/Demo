package com.roseoj.myapplication.core.designsystem.component

import androidx.compose.foundation.background
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.adaptive.WindowAdaptiveInfo
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffold
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffoldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavDestination.Companion.hierarchy
import com.roseoj.myapplication.app.app.DemoAppState
import com.roseoj.myapplication.app.navigation.DemoRoutes
import com.roseoj.myapplication.app.navigation.TopLevelDestination
import kotlin.reflect.KClass


@Composable
fun DemoNavigationScaffold(
    appState: DemoAppState,
    currentDestination: NavDestination?,
    windowAdaptiveInfo: WindowAdaptiveInfo,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    NavigationSuiteScaffold(
        containerColor = Color.Unspecified,
        navigationSuiteItems = {
            TopLevelDestination.entries.forEach { destination ->
                val selected = currentDestination.isRouteInHierarchy(destination.route)
                item(
                    selected = selected,
                    onClick = { appState.navigateToTopLevelDestination(destination) },
                    icon = {
                        Icon(
                            painter = painterResource(
                                if(selected) destination.selectedIcon
                                else destination.unselectedIcon
                            ),
                            contentDescription = null,
                            tint = Color.Unspecified
                        )
                    },
                    label = {
                        Text(
                            text = stringResource(destination.text),
                            color = if(selected) MaterialTheme.colorScheme.primary
                                else MaterialTheme.colorScheme.secondary
                        )
                    }
                )
            }
        },
        layoutType = NavigationSuiteScaffoldDefaults
            .calculateFromAdaptiveInfo(windowAdaptiveInfo),
        modifier = modifier.background(Color.Unspecified),
        content = content
    )
}

private fun NavDestination?.isRouteInHierarchy(route: KClass<*>) =
    this?.hierarchy?.any {
        it.hasRoute(route)
    } ?: false

fun NavController.navigateToHome() = navigate(route = DemoRoutes.HomeRoute)

fun NavController.navigateToSearch() = navigate(route = DemoRoutes.SearchRoute)

fun NavController.navigateToCart() = navigate(route = DemoRoutes.CartRoute)

fun NavController.navigateToOrder() = navigate(route = DemoRoutes.OrderRoute)

fun NavController.navigateToProfile() = navigate(route = DemoRoutes.ProfileRoute)
