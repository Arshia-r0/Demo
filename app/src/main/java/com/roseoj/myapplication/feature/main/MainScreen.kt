package com.roseoj.myapplication.feature.main

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController


@Composable
fun MainScreen(
    navController: NavController = rememberNavController()
) {
    Text("mainScreen")
}