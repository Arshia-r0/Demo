package com.roseoj.myapplication.feature.welcome.onboarding

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class OnboardingScreenViewModel @Inject constructor(): ViewModel() {
    
    val page = mutableStateOf(OnboardingPages.Page1)
    
}