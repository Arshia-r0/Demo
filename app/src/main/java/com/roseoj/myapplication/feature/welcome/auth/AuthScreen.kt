package com.roseoj.myapplication.feature.welcome.auth

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController


@Composable
fun AuthScreen(
    navController: NavController,
    viewModel: AuthScreenViewModel = hiltViewModel()
) {
    Column {
        Text("authScreen")
        Button(onClick = { viewModel.authenticate() }) {
            Text("setToken")
        }
    }
}
