package com.roseoj.myapplication.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.roseoj.myapplication.core.designsystem.theme.MyApplicationTheme
import com.roseoj.myapplication.core.network.util.NetworkMonitor
import com.roseoj.myapplication.feature.welcome.WelcomeNavHost
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject
import org.koin.androidx.compose.KoinAndroidContext


class MainActivity : ComponentActivity() {

    private val networkMonitor by inject<NetworkMonitor>()
    
    private val viewModel by inject<MainActivityViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        val splashScreen = installSplashScreen()
        super.onCreate(savedInstanceState)
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
                is MainActivityUiState.Success -> false
            }
        }

        enableEdgeToEdge()
        setContent {
            KoinAndroidContext {
                MyApplicationTheme {
                    if(uiState is MainActivityUiState.Success) {
                        WelcomeNavHost(
                            networkMonitor = networkMonitor,
                            isAuthorized = (uiState as MainActivityUiState.Success).data.authorized
                        )
                    }
                }
            }
        }
    }

}
