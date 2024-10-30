package com.roseoj.myapplication.core.datastore.di

import androidx.datastore.core.DataStoreFactory
import androidx.datastore.dataStoreFile
import com.roseoj.myapplication.core.datastore.DemoPreferencesDataSource
import com.roseoj.myapplication.core.datastore.UserDataSerializer
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module


val dataStoreModule = module {
    
    single {
        DataStoreFactory.create(
            serializer = UserDataSerializer,
            produceFile = { androidContext().dataStoreFile("demo.pb") },
            scope = CoroutineScope(Dispatchers.IO + SupervisorJob())
        )
    }
    
    singleOf(::DemoPreferencesDataSource)
    
}