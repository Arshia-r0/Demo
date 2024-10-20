package com.roseoj.myapplication.core.data.repository

import com.roseoj.myapplication.core.datastore.DemoPreferencesDataSource
import com.roseoj.myapplication.core.model.data.UserData
import com.roseoj.myapplication.core.model.data.type.AppTheme
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class UserDataRepository @Inject constructor(
    private val demoPreferencesDataSource: DemoPreferencesDataSource
){

    val userData: Flow<UserData> = demoPreferencesDataSource.userData

    suspend fun setAppTheme(appTheme: AppTheme) {
        demoPreferencesDataSource.setAppTheme(appTheme)
    }

    suspend fun setAuthorization(token: Boolean) {
        demoPreferencesDataSource.setAuthorization(token)
    }


}
