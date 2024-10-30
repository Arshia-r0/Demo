package com.roseoj.myapplication.app.navigation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.roseoj.demo.R

enum class TopLevelRoutes(
    @DrawableRes val selectedIcon: Int,
    @DrawableRes val unselectedIcon: Int,
    @StringRes val text: Int,
) {
    ProfileRoute(
        selectedIcon = R.drawable.profile_selected,
        unselectedIcon = R.drawable.profile,
        text = R.string.navbar_profile,
    ),
    OrderRoute(
        selectedIcon = R.drawable.order_selected,
        unselectedIcon = R.drawable.order,
        text = R.string.navbar_order,
    ),
    CartRoute(
        selectedIcon = R.drawable.cart_selected,
        unselectedIcon = R.drawable.cart,
        text = R.string.navbar_cart,
    ),
    SearchRoute(
        selectedIcon = R.drawable.search_selected,
        unselectedIcon = R.drawable.search,
        text = R.string.navbar_search,
    ),
    HomeRoute(
        selectedIcon = R.drawable.home_selected,
        unselectedIcon = R.drawable.home,
        text = R.string.navbar_home,
    ),
}