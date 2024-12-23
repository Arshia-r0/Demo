package com.roseoj.myapplication.feature.main.cart

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color


@Composable
fun CartScreen(
    ip: PaddingValues
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(ip)
    ) {
        Text(
            text = "CartScreen",
            color = Color.Black,
        )
    }
}