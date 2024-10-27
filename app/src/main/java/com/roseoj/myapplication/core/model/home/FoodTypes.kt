package com.roseoj.myapplication.core.model.home

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes


data class FoodTypes(
    @StringRes val title: Int,
    @DrawableRes val image: Int
)
