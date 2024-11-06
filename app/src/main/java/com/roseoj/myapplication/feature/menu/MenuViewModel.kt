package com.roseoj.myapplication.feature.menu

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.roseoj.myapplication.feature.menu.components.MenuCategory
import com.roseoj.myapplication.feature.menu.components.MenuLazyData
import com.roseoj.myapplication.feature.menu.components.MenuTabs


class MenuViewModel : ViewModel() {
    
    private val currentTab = mutableStateOf(MenuTabs.Main)
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
    val categoryRange = data.categories.associateWith {
        val start = getCategoryPosition(it)
        start..start + it.items.size
    }
    
    fun getCurrentTab(tabs: MenuTabs): MutableState<MenuTabs> {
        currentTab.value = tabs
        return currentTab
    }
    
    private fun getCategoryPosition(category: MenuCategory): Int {
        var p = 0
        data.categories.forEach {
            if (it != category) p += it.items.size + 1
            else return p
        }
        return p
    }
    
}
