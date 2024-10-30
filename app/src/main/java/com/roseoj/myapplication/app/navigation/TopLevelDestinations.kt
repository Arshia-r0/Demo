package com.roseoj.myapplication.app.navigation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.roseoj.demo.R

enum class TopLevelDestinations(
    @DrawableRes val selectedIcon: Int,
    @DrawableRes val unselectedIcon: Int,
    @StringRes val text: Int,
) {
    Profile(
        selectedIcon = R.drawable.profile_selected,
        unselectedIcon = R.drawable.profile,
        text = R.string.navbar_profile,
    ),
    Order(
        selectedIcon = R.drawable.order_selected,
        unselectedIcon = R.drawable.order,
        text = R.string.navbar_order,
    ),
    Cart(
        selectedIcon = R.drawable.cart_selected,
        unselectedIcon = R.drawable.cart,
        text = R.string.navbar_cart,
    ),
    Search(
        selectedIcon = R.drawable.search_selected,
        unselectedIcon = R.drawable.search,
        text = R.string.navbar_search,
    ),
    Home(
        selectedIcon = R.drawable.home_selected,
        unselectedIcon = R.drawable.home,
        text = R.string.navbar_home,
    ),
}