package com.roseoj.myapplication.feature.product

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.roseoj.demo.R
import com.roseoj.myapplication.core.designsystem.component.DemoScaffold
import com.roseoj.myapplication.core.model.product.FoodDetails
import com.roseoj.myapplication.feature.menu.components.ScoreStars


@Preview(showBackground = true)
@Composable
fun ProductScreen(
    food: FoodDetails = FoodDetails(
        title = "title",
        price = 123456,
        contents = "contents",
        score = 1 to 34
    ),
    navigateBack: () -> Unit = {},
) {
    DemoScaffold(
        title = "ProductScreen",
        backAction = navigateBack,
    ) { ip ->
        Column(
            modifier = Modifier
                .padding(ip)
                .padding(bottom = 50.dp, top = 20.dp)
                .padding(horizontal = 30.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f)
                    .padding(bottom = 30.dp)
            ) {
                Image(
                    painter = painterResource(R.drawable.tarkhine),
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize()
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Icon(
                    painter = painterResource(R.drawable.cart),
                    contentDescription = null,
                )
                Spacer(modifier = Modifier.width(10.dp))
                Icon(
                    imageVector = Icons.Default.Favorite,
                    contentDescription = null,
                )
                Text(
                    modifier = Modifier.weight(1f),
                    text = food.title,
                    textAlign = TextAlign.End,
                    style = MaterialTheme.typography.headlineSmall,
                )
            }
            Column(
                modifier = Modifier
                    .padding(top = 10.dp)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(10.dp))
                    .border(
                        border = BorderStroke(
                            width = 1.dp,
                            MaterialTheme.colorScheme.secondary,
                        ),
                        shape = RoundedCornerShape(10.dp)
                    )
                    .padding(horizontal = 10.dp)
            ) {
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp),
                    text = "محتویات",
                    style = MaterialTheme.typography.bodyLarge,
                    textAlign = TextAlign.End,
                )
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = food.contents,
                    style = MaterialTheme.typography.bodySmall,
                    textAlign = TextAlign.End,
                )
                HorizontalDivider(
                    color = MaterialTheme.colorScheme.secondary,
                    thickness = 1.dp,
                    modifier = Modifier.padding(vertical = 10.dp)
                )
                Row(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    ScoreStars(food.score.first)
                    Text(text = food.score.second.toString())
                    Text(
                        modifier = Modifier.weight(1f),
                        text = "امتیاز",
                        style = MaterialTheme.typography.bodyLarge,
                        textAlign = TextAlign.End
                    )
                }
                HorizontalDivider(
                    color = MaterialTheme.colorScheme.secondary,
                    thickness = 1.dp,
                    modifier = Modifier.padding(vertical = 10.dp)
                )
                Row(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(text = food.price.toString())
                    Text(
                        modifier = Modifier
                            .padding(bottom = 10.dp)
                            .weight(1f),
                        text = "قیمت",
                        style = MaterialTheme.typography.bodyLarge,
                        textAlign = TextAlign.End
                    )
                }
            }
            Button(
                modifier = Modifier.padding(top = 20.dp),
                onClick = {}
            ) {
                Text(
                    text = "افزودن به سبد خرید"
                )
            }
        }
    }
}
