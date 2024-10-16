package com.roseoj.myapplication.core.network


interface DemoNetwork {
    
    suspend fun authWithToken(token: String): Boolean
    
}