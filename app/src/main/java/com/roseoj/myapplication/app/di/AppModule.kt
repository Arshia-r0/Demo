package com.roseoj.myapplication.app.di

import com.roseoj.myapplication.app.MainActivityViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module


val appModule = module {
    
    viewModelOf(::MainActivityViewModel)
    
}