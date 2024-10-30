package com.roseoj.myapplication.core.designsystem.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val LightColorScheme = lightColorScheme(
    primary = Color(0xFF417F56),
    secondary = Color(0xFFCBCBCB),
    error = Color(0xFFD75D5D),
    errorContainer = Color(0xFFFFF2F2),
    primaryContainer = Color(0xFFE5F2E9),
    secondaryContainer = Color(0xFFEDEDED)
)

@Composable
fun MyApplicationTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = LightColorScheme,
        typography = Typography,
        content = content
    )
}
