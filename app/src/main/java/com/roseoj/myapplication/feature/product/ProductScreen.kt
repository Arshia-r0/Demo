package com.roseoj.myapplication.feature.product

import androidx.compose.runtime.Composable
import com.roseoj.myapplication.core.designsystem.component.DemoScaffold
import org.koin.androidx.compose.koinViewModel


@Composable
fun ProductScreen(
    backAction: () -> Unit = {},
    viewModel: ProductViewModel = koinViewModel()
) {
    DemoScaffold(
        title = "ProductScreen",
        backAction = backAction,
    ) { ip ->
    
    }
}
