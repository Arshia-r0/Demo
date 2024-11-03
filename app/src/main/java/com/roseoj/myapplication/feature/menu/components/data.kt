package com.roseoj.myapplication.feature.menu.components

import com.roseoj.myapplication.core.model.product.FoodDetails


data class MenuLazyData(
    val categories: List<MenuCategory>
)

data class MenuCategory(
    val title: String,
    val items: List<FoodDetails> = l,
)

val l = listOf(
    FoodDetails(
        title = "titl3e",
        price = 120000,
        contents = "contents",
        score = 3 to 23
    ),
    FoodDetails(
        title = "ti234525tle",
        price = 120000,
        contents = "contents",
        score = 4 to 23
    ),
    FoodDetails(
        title = "titl77777777e",
        price = 120000,
        contents = "contents",
        score = 0 to 23
    ),
    FoodDetails(
        title = "titl77777e",
        price = 120235000,
        contents = "contents",
        score = 2 to 23
    ),
    FoodDetails(
        title = "title",
        price = 120000,
        contents = "contents",
        score = 5 to 23
    ),
    FoodDetails(
        title = "tit34le",
        price = 1325000,
        contents = "contents",
        score = 1 to 23
    ),
    FoodDetails(
        title = "title",
        price = 120000,
        contents = "contents",
        score = 5 to 23
    )
)
