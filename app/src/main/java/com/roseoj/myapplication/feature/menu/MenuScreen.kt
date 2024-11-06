package com.roseoj.myapplication.feature.menu

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.roseoj.myapplication.core.designsystem.component.DemoScaffold
import com.roseoj.myapplication.core.designsystem.component.DemoText
import com.roseoj.myapplication.core.model.product.FoodDetails
import com.roseoj.myapplication.feature.menu.components.MenuTabs
import com.roseoj.myapplication.feature.menu.components.section
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
    var currentTab by viewModel.getCurrentTab(tab)
    val tabsList = viewModel.tabsList
    val data = viewModel.data
    val categoryRange = viewModel.categoryRange
    val firstVisibleItem by remember {
        derivedStateOf {
            lazyState.firstVisibleItemIndex
        }
    }
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
                        DemoText(
                            text = it.name,
                            color = if (it == currentTab) MaterialTheme.colorScheme.primary
                            else Color.Black,
                        )
                    }
                }
            }
            LazyRow(
                modifier = Modifier
                    .fillMaxWidth(),
                reverseLayout = true,
            ) {
                items(data.categories) {
                    Button(
                        onClick = {
                            scope.launch {
                                lazyState.animateScrollToItem(categoryRange[it]?.first ?: 0)
                            }
                        },
                        modifier = Modifier.padding(horizontal = 10.dp, vertical = 5.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = if (categoryRange[it]?.contains(firstVisibleItem) == true) MaterialTheme.colorScheme.primary
                            else MaterialTheme.colorScheme.secondary
                        )
                    ) {
                        Text(text = it.title)
                    }
                }
            }
            LazyColumn(
                state = lazyState,
                modifier = Modifier.fillMaxWidth(),
            ) {
                data.categories.forEach {
                    section(
                        menuCategory = it,
                        toProductScreen = toProductScreen,
                    )
                }
            }
        }
    }
}

