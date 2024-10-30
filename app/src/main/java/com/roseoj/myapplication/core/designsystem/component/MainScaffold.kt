package com.roseoj.myapplication.core.designsystem.component

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.adaptive.WindowAdaptiveInfo
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.roseoj.demo.R
import com.roseoj.myapplication.app.app.DemoAppState
import com.roseoj.myapplication.app.navigation.TopLevelRoutes


@Composable
fun MainScaffold(
    appState: DemoAppState,
    currentDestination: TopLevelRoutes,
    windowAdaptiveInfo: WindowAdaptiveInfo,
    isOffline: Boolean,
    snackBarHostState: SnackbarHostState,
    context: Context = LocalContext.current,
    content: @Composable () -> Unit,
) {
    LaunchedEffect(isOffline) {
        if (isOffline) {
            snackBarHostState.showSnackbar(
                message = context.getString(R.string.not_connected_message),
                duration = SnackbarDuration.Indefinite
            )
        }
    }
    DemoNavigationScaffold(
        appState = appState,
        currentDestination = currentDestination,
        windowAdaptiveInfo = windowAdaptiveInfo,
    ) {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            snackbarHost = {
                SnackbarHost(snackBarHostState) {
                    DemoSnackbar(it)
                }
            },
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
                        .height(70.dp)
                        .padding(10.dp),
                    horizontalArrangement = Arrangement.End
                ) {
                    Icon(
                        painter = painterResource(R.drawable.tarkhine),
                        contentDescription = "icon"
                    )
                }
                content()
            }
        }
    }
}