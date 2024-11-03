package com.roseoj.myapplication.feature.menu.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.roseoj.demo.R
import com.roseoj.myapplication.core.model.product.FoodDetails


fun LazyListScope.section(
    menuCategory: MenuCategory,
    toProductScreen: (FoodDetails) -> Unit = {}
) {
    item {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
                .padding(horizontal = 10.dp),
            horizontalArrangement = Arrangement.End,
        ) {
            Text(
                text = menuCategory.title,
                color = Color.Black,
                style = MaterialTheme.typography.headlineMedium
            )
        }
    }
    items(menuCategory.items) {
        LazyFoodCategory(
            item = it,
            toProductScreen = toProductScreen
        )
    }
}

@Composable
@Preview(showBackground = true)
fun LazyFoodCategory(
    item: FoodDetails = FoodDetails(
        title = "title",
        price = 123000,
        contents = "contents",
        score = 3 to 12
    ),
    toProductScreen: (FoodDetails) -> Unit = {},
) {
    Row(
        modifier = Modifier
            .padding(10.dp)
            .clip(RoundedCornerShape(10.dp))
            .fillMaxWidth()
            .height(130.dp)
            .clickable {
                toProductScreen(item)
            }
    ) {
        Box(
            modifier = Modifier
                .fillMaxHeight()
                .weight(1f),
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp),
                horizontalAlignment = Alignment.End,
            ) {
                Text(
                    text = item.title,
                    style = MaterialTheme.typography.headlineSmall
                )
                Spacer(modifier = Modifier.height(10.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                ) {
                    Text(
                        text = item.price.toString()
                    )
                    Text(
                        text = item.contents
                    )
                }
                Spacer(modifier = Modifier.height(5.dp))
                Row(
                    modifier = Modifier.fillMaxSize(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Button(
                        onClick = {},
                    ) {
                        Text(
                            text = "add to cart"
                        )
                    }
                    ScoreStars(item.score.first)
                    Icon(
                        modifier = Modifier.clickable { },
                        painter = painterResource(R.drawable.heart),
                        contentDescription = null,
                        tint = Color.Unspecified
                    )
                }
            }
        }
        Box(
            modifier = Modifier
                .fillMaxHeight()
                .aspectRatio(1f),
        ) {
            Image(
                modifier = Modifier.fillMaxSize(),
                painter = painterResource(R.drawable.order_selected),
                contentDescription = null,
            )
        }
    }
}

@Composable
fun ScoreStars(
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
