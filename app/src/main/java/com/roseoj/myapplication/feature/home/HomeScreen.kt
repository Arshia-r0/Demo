package com.roseoj.myapplication.feature.home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.NestedScrollSource
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.unit.dp
import com.roseoj.myapplication.core.designsystem.component.MainScreenBox


@Composable
fun HomeScreen() {
    var showBottomSheet by remember { mutableStateOf(false) }
    val toggleBottomSheet = {
        showBottomSheet = !showBottomSheet
    }
    val nestedScrollConnection = object : NestedScrollConnection {
        override fun onPostScroll(
            consumed: Offset,
            available: Offset,
            source: NestedScrollSource
        ): Offset = available
    }
    Content(
        showBottomSheet = showBottomSheet,
        toggleBottomSheet = toggleBottomSheet,
        nestedScrollConnection = nestedScrollConnection,
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Content(
    showBottomSheet: Boolean = false,
    nestedScrollConnection: NestedScrollConnection,
    toggleBottomSheet: () -> Unit = {},
) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        LazyColumn {
            item {
                MainScreenBox(id = true, toggleBottomSheet = toggleBottomSheet)
                MainScreenBox(id = false, toggleBottomSheet = toggleBottomSheet)
                MainScreenBox(id = true, toggleBottomSheet = toggleBottomSheet)
                MainScreenBox(id = false, toggleBottomSheet = toggleBottomSheet)
                MainScreenBox(id = true, toggleBottomSheet = toggleBottomSheet)
                MainScreenBox(id = false, toggleBottomSheet = toggleBottomSheet)
            }
        }
    }
    if(showBottomSheet) {
        ModalBottomSheet(
            modifier = Modifier.nestedScroll(nestedScrollConnection),
            onDismissRequest = toggleBottomSheet,
            dragHandle = {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(40.dp)
                        .background(MaterialTheme.colorScheme.secondaryContainer),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Text(text = "choose location")
                }
            },
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(min = 150.dp, max = 500.dp)
                    .padding(horizontal = 15.dp)
                    .padding(top = 10.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                LazyColumn(
                    modifier = Modifier
                        .nestedScroll(nestedScrollConnection)
                        .fillMaxWidth()
                        .heightIn(max = 350.dp),
                    verticalArrangement = Arrangement.spacedBy(10.dp),
                ) {
                    items(10) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(80.dp)
                                .border(
                                    border = BorderStroke(
                                        1.dp,
                                        MaterialTheme.colorScheme.secondary
                                    ),
                                    shape = RoundedCornerShape(10.dp)
                                )
                                .clickable { },
                        ) {
                            Text("location")
                        }
                    }
                }
                Spacer(modifier = Modifier.height(10.dp))
                Button(
                    modifier = Modifier.height(40.dp),
                    onClick = toggleBottomSheet,
                ) {
                    Text("Submit")
                }
            }
        }
    }
}
