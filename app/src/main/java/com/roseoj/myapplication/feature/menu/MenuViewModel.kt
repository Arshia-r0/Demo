package com.roseoj.myapplication.feature.menu

import androidx.lifecycle.ViewModel
import com.roseoj.myapplication.feature.menu.components.MenuCategory
import com.roseoj.myapplication.feature.menu.components.MenuLazyData
import com.roseoj.myapplication.feature.menu.components.MenuTabs


class MenuViewModel : ViewModel() {
    
    val tabsList = MenuTabs.entries
    val data = MenuLazyData(
        listOf(
            MenuCategory("Iranian"),
            MenuCategory("Foreign"),
            MenuCategory("Pizza"),
            MenuCategory("Sandwich"),
            MenuCategory("Popular")
        )
    )
    val categoryRange = data.data.associateWith {
        val start = getCategoryPosition(it)
        start..start + it.items.size
    }
    
    private fun getCategoryPosition(category: MenuCategory): Int {
        var p = 0
        data.data.forEach {
            if (it != category) p += it.items.size + 1
            else return p
        }
        return p
    }
    
}
