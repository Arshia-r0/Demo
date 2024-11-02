package com.roseoj.myapplication.feature

import com.roseoj.myapplication.feature.main.home.HomeScreenViewModel
import com.roseoj.myapplication.feature.menu.MenuViewModel
import com.roseoj.myapplication.feature.product.ProductViewModel
import com.roseoj.myapplication.feature.welcome.auth.AuthScreenViewModel
import com.roseoj.myapplication.feature.welcome.onboarding.OnboardingScreenViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module


val viewModelModule = module {
    
    viewModelOf(::AuthScreenViewModel)
    viewModelOf(::OnboardingScreenViewModel)
    viewModelOf(::HomeScreenViewModel)
    viewModelOf(::MenuViewModel)
    viewModelOf(::ProductViewModel)
    
}
