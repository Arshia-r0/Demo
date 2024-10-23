package com.roseoj.myapplication.feature.welcome.onboarding

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel


class OnboardingScreenViewModel: ViewModel() {
    
    val page = mutableStateOf(OnboardingPages.Page1)
    
}