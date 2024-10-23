package com.roseoj.myapplication.feature.welcome.di

import com.roseoj.myapplication.feature.welcome.auth.AuthScreenViewModel
import com.roseoj.myapplication.feature.welcome.onboarding.OnboardingScreenViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module


val onboardingModule = module {
    
    viewModelOf(::AuthScreenViewModel)
    viewModelOf(::OnboardingScreenViewModel)
    
}