package com.roseoj.myapplication.core.data.repository

import com.roseoj.myapplication.core.datastore.DemoPreferencesDataSource
import com.roseoj.myapplication.core.model.data.UserData
import com.roseoj.myapplication.core.model.data.type.AppTheme
import kotlinx.coroutines.flow.Flow


class OfflineUserDataRepository(
    private val demoPreferencesDataSource: DemoPreferencesDataSource
): UserDataRepository {
    
    override val userData: Flow<UserData> = demoPreferencesDataSource.userData

    override suspend fun setAppTheme(appTheme: AppTheme) {
        demoPreferencesDataSource.setAppTheme(appTheme)
    }

    override suspend fun setAuthorization(token: Boolean) {
        demoPreferencesDataSource.setAuthorization(token)
    }
    
}
