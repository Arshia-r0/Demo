package com.roseoj.myapplication.app.app

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.roseoj.myapplication.app.MainActivityUiState
import com.roseoj.myapplication.app.navigation.DemoNavHost
import com.roseoj.myapplication.feature.welcome.WelcomeNavHost


@Composable
fun DemoApp(
    appState: DemoAppState,
    uiState: MainActivityUiState.Success
) {
    val snackBarHostState = remember { SnackbarHostState() }
    Scaffold(
        snackbarHost = { SnackbarHost(snackBarHostState) }
    ) { ip ->
        Column(
            modifier = Modifier.fillMaxSize().padding(ip)
        ) {
            if (!uiState.data.authorized) WelcomeNavHost()
            else DemoNavHost(appState)
        }
    }
}
