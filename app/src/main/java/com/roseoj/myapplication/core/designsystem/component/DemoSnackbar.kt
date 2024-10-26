package com.roseoj.myapplication.core.designsystem.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.SnackbarData
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@Composable
fun DemoSnackbar(
    snackbarData: SnackbarData
) {
    Card(
        shape = RoundedCornerShape(8.dp),
        border = BorderStroke(2.dp, Color.White),
        modifier = Modifier
            .padding(16.dp)
            .wrapContentSize()
    ) {
        Column(
            modifier = Modifier.padding(12.dp),
        ) {
            Text(text = snackbarData.visuals.message)
        }
    }
}
