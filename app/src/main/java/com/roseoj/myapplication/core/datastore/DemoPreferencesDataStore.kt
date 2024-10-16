package com.roseoj.myapplication.core.datastore

import androidx.datastore.core.DataStore
import com.roseoj.myapplication.core.model.data.UserData
import com.roseoj.myapplication.core.model.data.type.AppTheme
import kotlinx.coroutines.flow.map
import javax.inject.Inject


class DemoPreferencesDataSource @Inject constructor(
    private val userPreferences: DataStore<UserData>
) {

    val userData = userPreferences.data.map {
        UserData(
            appTheme = it.appTheme,
            authToken = it.authToken
        )
    }

    suspend fun setAppTheme(appTheme: AppTheme) {
        userPreferences.updateData {
            it.copy(appTheme = appTheme)
        }
    }

    suspend fun setToken(token: Boolean) {
        userPreferences.updateData {
            it.copy(authToken = token)
        }
    }

}
