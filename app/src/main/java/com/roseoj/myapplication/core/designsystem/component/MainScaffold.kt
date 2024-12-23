package com.roseoj.myapplication.core.designsystem.component

import android.content.Context
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.adaptive.WindowAdaptiveInfo
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.roseoj.demo.R
import com.roseoj.myapplication.app.DemoAppState
import com.roseoj.myapplication.app.navigation.TopLevelDestinations


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScaffold(
    appState: DemoAppState,
    currentDestination: TopLevelDestinations,
    windowAdaptiveInfo: WindowAdaptiveInfo,
    isOffline: Boolean,
    snackBarHostState: SnackbarHostState,
    context: Context = LocalContext.current,
    content: @Composable (PaddingValues) -> Unit,
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
            topBar = {
                TopAppBar(
                    title = {
                        when (currentDestination) {
                            TopLevelDestinations.Profile -> {}
                            TopLevelDestinations.Home -> {
                                Row(
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .padding(end = 20.dp, bottom = 5.dp),
                                    horizontalArrangement = Arrangement.End
                                ) {
                                    Icon(
                                        painter = painterResource(R.drawable.tarkhine),
                                        contentDescription = "icon",
                                        tint = Color.White,
                                    )
                                }
                            }
                            
                            else -> {
                                Row(
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .padding(end = 20.dp, bottom = 5.dp),
                                    horizontalArrangement = Arrangement.Center,
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Text(
                                        text = currentDestination.name,
                                        color = Color.White,
                                        style = MaterialTheme.typography.headlineMedium
                                    )
                                }
                            }
                        }
                    },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = MaterialTheme.colorScheme.primary,
                    ),
                )
            },
            snackbarHost = {
                SnackbarHost(snackBarHostState) {
                    DemoSnackbar(it)
                }
            },
        ) { ip ->
            content(ip)
        }
    }
}