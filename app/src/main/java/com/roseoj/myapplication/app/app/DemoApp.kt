package com.roseoj.myapplication.app.app

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.adaptive.WindowAdaptiveInfo
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.roseoj.demo.R
import com.roseoj.myapplication.app.navigation.DemoNavHost
import com.roseoj.myapplication.core.designsystem.component.DemoNavigationScaffold


@Composable
fun DemoApp(
    windowAdaptiveInfo: WindowAdaptiveInfo = currentWindowAdaptiveInfo()
) {
    val appState = rememberDemoAppState()
    val currentDestination = appState.currentDestination
    val snackBarHostState = remember { SnackbarHostState() }
    DemoNavigationScaffold(
        appState = appState,
        currentDestination = currentDestination,
        windowAdaptiveInfo = windowAdaptiveInfo,
    ) {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            snackbarHost = {
                SnackbarHost(snackBarHostState)
            },
            contentWindowInsets = WindowInsets(0,0,0,0)
        ) { ip ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(ip)
                    .consumeWindowInsets(ip)
            ) {
                Row(
                    modifier = Modifier
                        .background(color = MaterialTheme.colorScheme.primary)
                        .fillMaxWidth()
                        .padding(10.dp),
                    horizontalArrangement = Arrangement.End
                ) {
                    Icon(
                        painter = painterResource(R.drawable.tarkhine),
                        contentDescription = "icon"
                    )
                }
                DemoNavHost(
                    appState = appState,
                )
            }
        }
    }
}
