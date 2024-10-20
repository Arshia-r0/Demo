package com.roseoj.myapplication.app.navigation

import kotlinx.serialization.Serializable


sealed interface DemoRoutes {
    @Serializable
    object MainScreen
}
