package com.roseoj.myapplication.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.roseoj.myapplication.app.ui.rememberDemoAppState
import com.roseoj.myapplication.core.designsystem.theme.MyApplicationTheme
import com.roseoj.myapplication.app.ui.DemoApp
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: MainActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        val splashScreen = installSplashScreen()
        super.onCreate(savedInstanceState)
        var loading by mutableStateOf(true)
        var uiState: MainActivityUiState by mutableStateOf(MainActivityUiState.Loading)

        lifecycleScope.launch {
            lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.uiState
                    .onEach { uiState = it }
                    .collect{}
            }
        }

        splashScreen.setKeepOnScreenCondition {
            when(uiState) {
                MainActivityUiState.Loading -> true
                is MainActivityUiState.Success -> false.also {
                    loading = false
                }
            }
        }

        enableEdgeToEdge()
        setContent {
            val appState = rememberDemoAppState()
            MyApplicationTheme {
                if(!loading) DemoApp(
                    appState,
                    uiState as MainActivityUiState.Success
                )
            }
        }
    }

}