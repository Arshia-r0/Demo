package com.roseoj.myapplication.app.ui

import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.res.stringResource
import com.roseoj.demo.R
import com.roseoj.myapplication.feature.auth.AuthScreen


@Composable
fun DemoApp(
    appState: DemoAppState,
) {
    val snackBarHostState = remember { SnackbarHostState() }
    DemoApp(
        appState = appState,
        snackBarHostState = snackBarHostState,
    )
}

@Composable
internal fun DemoApp(
    appState: DemoAppState,
    snackBarHostState: SnackbarHostState,
) {
    val currentDestination = appState.currentDestination
    AuthScreen()
}
