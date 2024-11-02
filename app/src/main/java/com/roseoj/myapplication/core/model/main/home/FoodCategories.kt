package com.roseoj.myapplication.core.model.main.home

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes


data class FoodCategories(
    @StringRes val title: Int,
    @DrawableRes val image: Int
)
