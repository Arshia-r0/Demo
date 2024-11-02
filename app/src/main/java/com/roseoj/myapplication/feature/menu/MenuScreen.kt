package com.roseoj.myapplication.feature.menu

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.roseoj.myapplication.core.designsystem.component.DemoScaffold
import org.koin.androidx.compose.koinViewModel


@Composable
fun MenuScreen(
    backAction: () -> Unit = {},
    toProductScreen: () -> Unit = {},
    viewModel: MenuViewModel = koinViewModel()
) {
    DemoScaffold(
        title = "Menu",
        backAction = backAction,
    ) { ip ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(ip)
        ) {
            Button(
                onClick = toProductScreen,
            ) {
                Text(text = "product")
            }
        }
    }
}
