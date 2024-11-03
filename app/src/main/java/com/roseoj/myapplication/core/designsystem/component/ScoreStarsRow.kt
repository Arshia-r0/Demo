package com.roseoj.myapplication.core.designsystem.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.roseoj.demo.R


@Composable
fun ScoreStarsRow(
    score: Int = 3
) {
    Row(
        modifier = Modifier,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        repeat(score) {
            Icon(
                painter = painterResource(R.drawable.star_1),
                contentDescription = null,
                tint = Color.Unspecified
            )
        }
        repeat(5 - score) {
            Icon(
                painter = painterResource(R.drawable.star_4),
                contentDescription = null,
                tint = Color.Unspecified
            )
        }
    }
}
