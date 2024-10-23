package com.roseoj.myapplication.core.data.di

import com.roseoj.myapplication.core.data.repository.OfflineUserDataRepository
import com.roseoj.myapplication.core.data.repository.UserDataRepository
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module


val dataModule = module {
    
    singleOf(::OfflineUserDataRepository) {
        bind<UserDataRepository>()
    }
    
}
