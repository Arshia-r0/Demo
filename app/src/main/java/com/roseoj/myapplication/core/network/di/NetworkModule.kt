package com.roseoj.myapplication.core.network.di

import com.roseoj.myapplication.core.network.util.ConnectivityManagerNetworkMonitor
import com.roseoj.myapplication.core.network.util.NetworkMonitor
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module


val networkModule = module {

    singleOf(::ConnectivityManagerNetworkMonitor) {
        bind<NetworkMonitor>()
    }

}
