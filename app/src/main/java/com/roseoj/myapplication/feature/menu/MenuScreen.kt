package com.roseoj.myapplication.feature.menu

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
    var currentTab by remember { mutableStateOf(tab) }
    val tabsList = viewModel.tabsList
    val data = viewModel.data
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
                    items(data.data) {
                        Button(
                            onClick = {
                                scope.launch {
                                    lazyState.animateScrollToItem(viewModel.getCategoryPosition(it))
                                }
                            },
                            modifier = Modifier.padding(horizontal = 10.dp)
                        ) {
                            Text(text = it.title)
                        }
                    }
                }
                LazyColumn(
                    state = lazyState,
                    modifier = Modifier.fillMaxWidth(),
                ) {
                    data.data.forEach {
                        section(
                            menuCategory = it,
                            toProductScreen = toProductScreen,
                        )
                    }
                }
            }
        }
    }
}

