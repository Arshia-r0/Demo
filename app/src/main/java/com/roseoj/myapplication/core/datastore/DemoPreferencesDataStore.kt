package com.roseoj.myapplication.core.datastore

import androidx.datastore.core.DataStore
import com.roseoj.myapplication.core.model.data.UserData
import com.roseoj.myapplication.core.model.data.type.AppTheme
import kotlinx.coroutines.flow.map


class DemoPreferencesDataSource(
    private val dataStore: DataStore<UserData>
) {

    val userData = dataStore.data.map {
        UserData(
            appTheme = it.appTheme,
            authorized = it.authorized
        )
    }

    suspend fun setAppTheme(appTheme: AppTheme) {
        dataStore.updateData {
            it.copy(appTheme = appTheme)
        }
    }

    suspend fun setAuthorization(token: Boolean) {
        dataStore.updateData {
            it.copy(authorized = token)
        }
    }

}
