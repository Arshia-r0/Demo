package com.roseoj.myapplication.feature.di

import com.roseoj.myapplication.feature.home.HomeScreenViewModel
import com.roseoj.myapplication.feature.welcome.auth.AuthScreenViewModel
import com.roseoj.myapplication.feature.welcome.onboarding.OnboardingScreenViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module


val featureModule = module {
    
    viewModelOf(::AuthScreenViewModel)
    viewModelOf(::OnboardingScreenViewModel)
    viewModelOf(::HomeScreenViewModel)
    
}