package com.roseoj.myapplication.core.model.main

import androidx.annotation.DrawableRes


data class Food(
    val id: Int,
    val title: String,
    @DrawableRes val image: Int,
    val price: Int,
)
