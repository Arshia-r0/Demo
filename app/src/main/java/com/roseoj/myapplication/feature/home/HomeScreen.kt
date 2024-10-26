package com.roseoj.myapplication.feature.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import com.roseoj.myapplication.app.app.DemoAppState
import org.koin.androidx.compose.koinViewModel


@Composable
fun HomeScreen(
    appState: DemoAppState,
    viewModel: HomeScreenViewModel = koinViewModel()
) {
   Content()
}

@Preview
@PreviewScreenSizes
@Composable
fun Content() {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Text("HomeScreen")
    }
}
