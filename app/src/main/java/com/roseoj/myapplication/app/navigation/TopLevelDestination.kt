package com.roseoj.myapplication.app.navigation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.roseoj.demo.R
import kotlin.reflect.KClass


enum class TopLevelDestination(
    @DrawableRes val selectedIcon: Int,
    val unselectedIcon: Int,
    @StringRes val text: Int,
    val route: KClass<*>
) {
    PROFILE(
        selectedIcon = R.drawable.profile_selected,
        unselectedIcon = R.drawable.profile,
        text = R.string.navbar_profile,
        route = DemoRoutes.MainRoutes.ProfileRoute::class
    ),
    ORDER(
        selectedIcon = R.drawable.order_selected,
        unselectedIcon = R.drawable.order,
        text = R.string.navbar_order,
        route = DemoRoutes.MainRoutes.OrderRoute::class
    ),
    CART(
        selectedIcon = R.drawable.cart_selected,
        unselectedIcon = R.drawable.cart,
        text = R.string.navbar_cart,
        route = DemoRoutes.MainRoutes.CartRoute::class
    ),
    SEARCH(
        selectedIcon = R.drawable.search_selected,
        unselectedIcon = R.drawable.search,
        text = R.string.navbar_search,
        route = DemoRoutes.MainRoutes.SearchRoute::class
    ),
    HOME(
        selectedIcon = R.drawable.home_selected,
        unselectedIcon = R.drawable.home,
        text = R.string.navbar_home,
        route = DemoRoutes.MainRoutes.HomeRoute::class
    )
}