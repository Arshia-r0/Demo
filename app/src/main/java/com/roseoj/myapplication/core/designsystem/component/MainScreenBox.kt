package com.roseoj.myapplication.core.designsystem.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.roseoj.demo.R
import com.roseoj.myapplication.core.model.home.Category
import com.roseoj.myapplication.core.model.home.Food
import com.roseoj.myapplication.feature.menu.components.MenuTabs


@Preview
@Composable
fun MainScreenBox(
    id: Boolean = true,
    category: Category = Category(
        title = "پیشنهاد ویژه",
        items = listOf(
            Food(
                id = 1,
                title = "دلمه برگ کلم",
                image = R.drawable.home,
                price = 209000,
            ),
            Food(
                id = 2,
                title = "بادمجان شکم پر",
                image = R.drawable.order,
                price = 136000
            ),
            Food(
                id = 3,
                title = "admgpag",
                image = R.drawable.order,
                price = 344000
            ),
            Food(
                id = 4,
                title = "oiajagdadg",
                image = R.drawable.order,
                price = 126000
            )
        ),
    ),
    toggleBottomSheet: () -> Unit = {},
) {
   Column(
       modifier = Modifier
           .fillMaxWidth()
           .height(360.dp)
           .background(if (id) MaterialTheme.colorScheme.primaryContainer else Color.White)
           .padding(vertical = 15.dp),
       verticalArrangement = Arrangement.spacedBy(20.dp)
   ) {
       Row(
           modifier = Modifier.fillMaxWidth(),
           horizontalArrangement = Arrangement.End
       ) {
           Text(
               text = category.title,
               textAlign = TextAlign.End,
               modifier = Modifier
                   .width(150.dp)
                   .clip(RoundedCornerShape(topStart = 5.dp, bottomStart = 5.dp))
                   .background(if (id) Color.White else MaterialTheme.colorScheme.primaryContainer)
                   .padding(10.dp)
           )
       }
       LazyRow(
           modifier = Modifier
               .fillMaxWidth()
               .weight(1f),
           reverseLayout = true,
           horizontalArrangement = Arrangement.End,
       ) {
           items(items = category.items, key = { it.id }) {
               Box(
                   modifier = Modifier
                       .padding(5.dp)
                       .fillMaxHeight()
                       .width(160.dp)
                       .clip(RoundedCornerShape(5.dp))
                       .background(Color.White)
                       .padding(5.dp)
               ) {
                   Column(
                       modifier = Modifier.fillMaxSize(),
                       horizontalAlignment = Alignment.CenterHorizontally,
                       verticalArrangement = Arrangement.Center,
                   ) {
                       Image(
                           painter = painterResource(it.image),
                           contentDescription = "image",
                           modifier = Modifier
                               .fillMaxHeight(0.5f)
                               .fillMaxWidth(),
                       )
                       Spacer(modifier = Modifier.height(10.dp))
                       Row(
                           modifier = Modifier.fillMaxWidth(),
                           horizontalArrangement = Arrangement.SpaceEvenly,
                           verticalAlignment = Alignment.CenterVertically,
                       ) {
                           Text(
                               text = it.price.toString(),
                               fontSize = 12.sp
                           )
                           Text(
                               textAlign = TextAlign.End,
                               text = it.title,
                               fontSize = 12.sp
                           )
                       }
                       Spacer(modifier = Modifier.height(10.dp))
                       Button(
                           onClick = toggleBottomSheet,
                           shape = RoundedCornerShape(10.dp),
                           contentPadding = PaddingValues(0.dp),
                           modifier = Modifier.fillMaxWidth()
                       ) {
                            Text(
                                modifier = Modifier.padding(horizontal = 5.dp),
                                text = "افزودن به سبد خرید",
                                fontSize = 12.sp,
                                textAlign = TextAlign.Center,
                            )
                       }
                   }
               }
           }
       }
   }
}

@Composable
fun Box1(
    toMenuScreen: (MenuTabs) -> Unit,
) {
    LazyRow(
        reverseLayout = true,
        horizontalArrangement = Arrangement.End,
    ) {
        items(items = MenuTabs.entries.reversed(), key = { it.ordinal }) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.padding(15.dp)
            ) {
                Button(
                    onClick = { toMenuScreen(it) },
                ) {
                    Text(it.toString())
                }
            }
        }
    }
}
