package com.roseoj.myapplication.core.model.data

import com.roseoj.myapplication.core.model.data.type.AppTheme
import kotlinx.serialization.Serializable


@Serializable
data class UserData(
    val appTheme: AppTheme = AppTheme.FollowSystem,
    val authorized: Boolean = false
)
