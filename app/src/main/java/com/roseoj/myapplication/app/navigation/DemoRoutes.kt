package com.roseoj.myapplication.app.navigation

import kotlinx.serialization.Serializable


sealed interface DemoRoutes {
    @Serializable
    object HomeRoute
    @Serializable
    object SearchRoute
    @Serializable
    object CartRoute
    @Serializable
    object OrderRoute
    @Serializable
    object ProfileRoute
}
