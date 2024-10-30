package com.roseoj.myapplication.feature.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import com.roseoj.myapplication.core.designsystem.component.MainScreenBox


@Composable
fun HomeScreen() {
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
                MainScreenBox(false)
                MainScreenBox(true)
                MainScreenBox(false)
            }
        }
    }
}
