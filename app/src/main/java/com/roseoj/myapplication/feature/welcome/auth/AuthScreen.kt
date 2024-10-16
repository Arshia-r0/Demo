package com.roseoj.myapplication.feature.welcome.auth

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel


@Composable
fun AuthScreen(
    viewModel: AuthScreenViewModel = hiltViewModel()
) {
   Text("authScreen")
}
