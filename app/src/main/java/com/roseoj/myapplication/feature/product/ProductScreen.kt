package com.roseoj.myapplication.feature.product

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.roseoj.myapplication.core.designsystem.component.DemoScaffold
import com.roseoj.myapplication.core.model.product.FoodDetails


@Composable
fun ProductScreen(
    food: FoodDetails,
    navigateBack: () -> Unit = {},
) {
    DemoScaffold(
        title = "ProductScreen",
        backAction = navigateBack,
    ) { ip ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(ip),
            contentAlignment = Alignment.Center,
        ) {
            Text(food.toString())
        }
    }
}
