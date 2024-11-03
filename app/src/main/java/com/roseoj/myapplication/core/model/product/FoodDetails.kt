package com.roseoj.myapplication.core.model.product

import kotlinx.serialization.Serializable


@Serializable
data class FoodDetails(
    val title: String,
    val price: Int,
    val contents: String,
    val score: Pair<Int, Int>
)