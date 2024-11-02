package com.roseoj.myapplication.feature.menu

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.roseoj.myapplication.core.designsystem.component.DemoScaffold
import com.roseoj.myapplication.feature.menu.components.MenuTabs
import org.koin.androidx.compose.koinViewModel


@Composable
fun MenuScreen(
    tab: MenuTabs = MenuTabs.Main,
    navigateBack: () -> Unit = {},
    toProductScreen: () -> Unit = {},
    viewModel: MenuViewModel = koinViewModel()
) {
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
                            .clip(RoundedCornerShape(10.dp))
                            .background(MaterialTheme.colorScheme.secondaryContainer)
                    ) {
                        Text(
                            text = it.name,
                            color = if (it == currentTab) MaterialTheme.colorScheme.primary
                            else Color.Black,
                        )
                    }
                }
            }
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth(),
                contentAlignment = Alignment.Center,
            ) {
                Button(
                    onClick = toProductScreen
                ) {
                    Text(text = currentTab.name)
                }
            }
        }
    }
}
