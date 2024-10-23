package com.roseoj.myapplication.core.designsystem.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorScheme = darkColorScheme(
    primary = Color(0xFF417F56),
    secondary = Color(0xFFCBCBCB),
    error = Color(0xFFD75D5D),
    errorContainer = Color(0xFFFFF2F2)
)

private val LightColorScheme = lightColorScheme(
    primary = Color(0xFF417F56),
    secondary = Color(0xFFCBCBCB),
    error = Color(0xFFD75D5D),
    errorContainer = Color(0xFFFFF2F2)
)

@Composable
fun MyApplicationTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}