package com.roseoj.myapplication.core.data.repository

import com.roseoj.myapplication.core.model.data.UserData
import com.roseoj.myapplication.core.model.data.type.AppTheme
import kotlinx.coroutines.flow.Flow

interface UserDataRepository {
    
    val userData: Flow<UserData>
    
    suspend fun setAppTheme(appTheme: AppTheme)
    
    suspend fun setAuthorization(token: Boolean)
    
}