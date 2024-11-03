package com.roseoj.myapplication.feature.menu

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.roseoj.myapplication.core.designsystem.component.DemoScaffold
import com.roseoj.myapplication.core.model.product.FoodDetails
import com.roseoj.myapplication.feature.menu.components.MenuTabs
import kotlinx.coroutines.launch
import org.koin.androidx.compose.koinViewModel


@Composable
fun MenuScreen(
    tab: MenuTabs,
    navigateBack: () -> Unit = {},
    toProductScreen: (FoodDetails) -> Unit = {},
    viewModel: MenuViewModel = koinViewModel()
) {
    val scope = rememberCoroutineScope()
    val lazyState = rememberLazyListState()
    val types = remember { arrayOf("Iranian", "Foreign", "Pizza") }
    var currentTab by remember { mutableStateOf(tab) }
    val tabsList = remember { MenuTabs.entries }
    DemoScaffold(
        title = "Menu",
        backAction = navigateBack,
    ) { ip ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(ip)
        ) {
            TabRow(
                containerColor = MaterialTheme.colorScheme.secondaryContainer,
                selectedTabIndex = currentTab.ordinal,
                divider = {},
                indicator = {},
            ) {
                tabsList.forEach {
                    Tab(
                        selected = it == currentTab,
                        onClick = { currentTab = it },
                        modifier = Modifier
                            .padding(10.dp)
                    ) {
                        Text(
                            text = it.name,
                            color = if (it == currentTab) MaterialTheme.colorScheme.primary
                            else Color.Black,
                        )
                    }
                }
            }
            if (currentTab != MenuTabs.Main) {
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth(),
                    contentAlignment = Alignment.Center,
                ) {
                    Text(currentTab.name)
                }
            } else {
                LazyRow(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    reverseLayout = true,
                ) {
                    items(types) {
                        Button(
                            onClick = {
                                scope.launch {
                                    lazyState.animateScrollToItem(14)
                                }
                            },
                            modifier = Modifier.padding(horizontal = 10.dp)
                        ) {
                            Text(text = it)
                        }
                    }
                }
                LazyColumn(
                    state = lazyState,
                    modifier = Modifier.fillMaxSize(),
                ) {
                    item {
                        MenuBox(
                            title = "Iranian",
                            food = null
                        )
                    }
                    items(5) {
                        MenuBox(
                            title = it.toString(),
                            toProductScreen = toProductScreen
                        )
                    }
                    item {
                        MenuBox(
                            title = "Foreign",
                            food = null
                        )
                    }
                    items(12) {
                        MenuBox(
                            title = it.toString(),
                            toProductScreen = toProductScreen
                        )
                    }
                    item {
                        MenuBox(
                            title = "Pizza",
                            food = null
                        )
                    }
                    items(11) {
                        MenuBox(
                            title = it.toString(),
                            toProductScreen = toProductScreen
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun MenuBox(
    title: String,
    toProductScreen: (FoodDetails) -> Unit = {},
    food: FoodDetails? = FoodDetails(
        title = "title",
        price = 120000,
        contents = "contents",
        score = 40 to 4.5f
    ),
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(70.dp)
            .clickable {
                if (food != null) {
                    toProductScreen(food)
                }
            },
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = food?.title ?: title,
            color = Color.Black
        )
    }
}