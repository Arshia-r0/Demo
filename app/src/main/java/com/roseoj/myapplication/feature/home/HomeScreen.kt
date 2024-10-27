package com.roseoj.myapplication.feature.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import com.roseoj.myapplication.app.app.DemoAppState
import com.roseoj.myapplication.core.designsystem.component.MainScreenBox
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
        LazyColumn {
            item {
                MainScreenBox(true)
                MainScreenBox(false)
                MainScreenBox(true)
            }
        }
    }
}
