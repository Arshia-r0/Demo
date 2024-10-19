package com.roseoj.myapplication.app.ui

import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
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
    Scaffold(
        snackbarHost = { SnackbarHost(snackBarHostState) }
    ) { ip ->
        DemoNavHost(
            appState = appState,
            uiState = uiState,
            ip = ip,
//            onShowSnackbar = { message, action ->
//                snackBarHostState.showSnackbar(
//                    message = message,
//                    actionLabel = action,
//                    duration = SnackbarDuration.Short,
//                ) == SnackbarResult.ActionPerformed
//            }
        )
    }
}
