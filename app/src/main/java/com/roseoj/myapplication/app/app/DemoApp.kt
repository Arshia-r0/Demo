package com.roseoj.myapplication.app.app

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.roseoj.myapplication.app.navigation.DemoNavHost


@Composable
fun DemoApp(
    appState: DemoAppState,
    isAuthorized: Boolean
) {
    val snackBarHostState = remember { SnackbarHostState() }
    Scaffold(
        snackbarHost = { SnackbarHost(snackBarHostState) }
    ) { ip ->
        Column(
            modifier = Modifier.fillMaxSize().padding(ip)
        ) {
            DemoNavHost(appState, isAuthorized)
        }
    }
}
