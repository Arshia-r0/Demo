package com.roseoj.myapplication.app.navigation

import android.net.Uri
import android.os.Bundle
import androidx.navigation.NavType
import com.roseoj.myapplication.core.model.product.FoodDetails
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json


object DemoNavTypes {
    
    val FoodDetailsType = object : NavType<FoodDetails>(
        isNullableAllowed = false,
    ) {
        
        override fun get(bundle: Bundle, key: String): FoodDetails? {
            return Json.decodeFromString(bundle.getString(key) ?: return null)
        }
        
        override fun parseValue(value: String): FoodDetails {
            return Json.decodeFromString(Uri.decode(value))
        }
        
        override fun put(bundle: Bundle, key: String, value: FoodDetails) {
            bundle.putString(key, Json.encodeToString(value))
        }
        
        override fun serializeAsValue(value: FoodDetails): String {
            return Uri.encode(Json.encodeToString(value))
        }
        
    }
    
}