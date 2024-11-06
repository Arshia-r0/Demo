package com.roseoj.myapplication.feature.main.navigation

import androidx.compose.runtime.mutableStateOf
import com.roseoj.myapplication.app.navigation.TopLevelDestinations

object Destination {
    
    val currentTopLevelDestination = mutableStateOf(TopLevelDestinations.Home)
    
}