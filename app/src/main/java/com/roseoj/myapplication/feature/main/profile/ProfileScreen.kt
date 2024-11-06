package com.roseoj.myapplication.feature.main.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.roseoj.demo.R
import com.roseoj.myapplication.core.designsystem.component.DemoText
import org.koin.androidx.compose.koinViewModel


@Preview(showBackground = true)
@Composable
fun ProfileScreen(
    ip: PaddingValues = PaddingValues(),
    viewModel: ProfileViewModel = koinViewModel()
) {
    var showDialog by remember { mutableStateOf(false) }
    val items = viewModel.items
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(ip),
        horizontalAlignment = Alignment.End,
    ) {
        item {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = MaterialTheme.colorScheme.primary),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    modifier = Modifier.padding(vertical = 30.dp),
                    painter = painterResource(R.drawable.profile),
                    contentDescription = null,
                )
            }
        }
        items(items) {
            DemoText(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { }
                    .padding(vertical = 15.dp, horizontal = 20.dp),
                text = it,
                style = MaterialTheme.typography.headlineSmall
            )
        }
        item {
            DemoText(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { showDialog = true }
                    .padding(vertical = 15.dp, horizontal = 20.dp),
                text = "خروج",
                style = MaterialTheme.typography.headlineSmall,
                color = MaterialTheme.colorScheme.error,
            )
        }
    }
    if (showDialog) {
        AlertDialog(
            onDismissRequest = { showDialog = false },
            title = {
                DemoText(
                    text = "خروج",
                    modifier = Modifier.fillMaxWidth()
                )
            },
            text = {
                DemoText(
                    text = "آبا مایل به خروج از حساب کاربری خود هستید؟",
                    modifier = Modifier.fillMaxWidth()
                )
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        showDialog = false
                        viewModel.logout()
                    }
                ) {
                    Text(
                        text = "خروج",
                    )
                }
            },
            dismissButton = {
                TextButton(
                    onClick = {
                        showDialog = false
                    }
                ) {
                    Text("بازگشت")
                }
            }
        )
    }
}
