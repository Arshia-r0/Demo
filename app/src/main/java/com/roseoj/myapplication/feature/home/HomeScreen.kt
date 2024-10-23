package com.roseoj.myapplication.feature.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import androidx.navigation.compose.rememberNavController
import com.roseoj.myapplication.app.app.DemoAppState
import org.koin.androidx.compose.koinViewModel


@Preview
@PreviewScreenSizes
@Composable
fun HomeScreen(
    appState: DemoAppState = DemoAppState(rememberNavController(), rememberCoroutineScope()),
    viewModel: HomeScreenViewModel = koinViewModel()
) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Text("HomeScreen")
    }
}