package com.roseoj.myapplication.app.ui

import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember


@Composable
fun DemoApp(
    appState: DemoAppState,
) {
    val snackBarHostState = remember { SnackbarHostState() }
    val currentDestination = appState.currentDestination
    Text("MainScreen")
}
