package com.roseoj.myapplication.core.designsystem.component

import androidx.compose.foundation.background
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.adaptive.WindowAdaptiveInfo
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteDefaults
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffold
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffoldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.roseoj.myapplication.app.navigation.TopLevelDestinations
import com.roseoj.myapplication.feature.main.navigation.Destination


@Composable
fun DemoNavigationScaffold(
    currentDestination: TopLevelDestinations,
    windowAdaptiveInfo: WindowAdaptiveInfo,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    NavigationSuiteScaffold(
        containerColor = Color.Unspecified,
        navigationSuiteColors = NavigationSuiteDefaults.colors(
            navigationBarContentColor = Color.Transparent,
            navigationRailContentColor = Color.Transparent,
            navigationBarContainerColor = Color.Transparent,
            navigationRailContainerColor = Color.Transparent,
            navigationDrawerContainerColor = Color.Transparent,
            navigationDrawerContentColor = Color.Transparent
        ),
        navigationSuiteItems = {
            TopLevelDestinations.entries.forEach { destination ->
                val selected = currentDestination == destination
                item(
                    selected = selected,
                    onClick = { Destination.currentTopLevelDestination.value = destination },
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
                            color = if(selected) MaterialTheme.colorScheme.primary else Color.Black
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
