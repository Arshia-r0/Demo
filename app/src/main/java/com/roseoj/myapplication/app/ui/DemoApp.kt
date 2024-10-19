package com.roseoj.myapplication.app.ui

import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.roseoj.myapplication.app.MainActivityUiState
import com.roseoj.myapplication.app.navigation.DemoNavHost


@Composable
fun DemoApp(
    appState: DemoAppState,
    uiState: MainActivityUiState.Success
) {
    val snackBarHostState = remember { SnackbarHostState() }
    val currentDestination = appState.currentDestination
    DemoNavHost(appState, uiState)
}
