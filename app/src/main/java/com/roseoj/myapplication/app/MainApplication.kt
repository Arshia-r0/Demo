package com.roseoj.myapplication.app

import android.app.Application
import com.roseoj.myapplication.app.di.appModule
import com.roseoj.myapplication.core.data.di.dataModule
import com.roseoj.myapplication.core.datastore.di.dataStoreModule
import com.roseoj.myapplication.core.network.di.networkModule
import com.roseoj.myapplication.feature.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin


class MainApplication: Application() {
    
    override fun onCreate() {
        super.onCreate()
        
        startKoin {
            androidLogger()
            androidContext(this@MainApplication)
            modules(
                appModule,
                viewModelModule,
                dataModule,
                dataStoreModule,
                networkModule
            )
        }
    }

}
