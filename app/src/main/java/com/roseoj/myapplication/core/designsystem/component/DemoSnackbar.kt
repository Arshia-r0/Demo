package com.roseoj.myapplication.core.designsystem.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SnackbarData
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun DemoSnackbar(
    snackbarData: SnackbarData,
) {
    Card(
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.errorContainer
        ),
        modifier = Modifier
            .padding(16.dp)
            .wrapContentSize()
    ) {
        Column(
            modifier = Modifier.padding(12.dp),
        ) {
            DemoText(
                text = snackbarData.visuals.message,
                color = MaterialTheme.colorScheme.error
            )
        }
    }
}
