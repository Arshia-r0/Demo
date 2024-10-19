package com.roseoj.myapplication.feature.welcome.onboarding

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.roseoj.demo.R
import com.roseoj.myapplication.app.navigation.DemoRoutes
import com.roseoj.myapplication.core.common.next


@Composable
fun OnboardingScreen(navController: NavController) {
    var page by remember { mutableStateOf(OnboardingPages.Page1) }
    val progress by animateFloatAsState(page.progress, label = "ProgressIndicator")
    val interactionSource = remember { MutableInteractionSource() }
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Box(
            modifier = Modifier.fillMaxWidth().height(300.dp),
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colorScheme.primary)
                    .padding(horizontal = 20.dp)
                    .padding(top = 60.dp, bottom = 100.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    textAlign = TextAlign.End,
                    text = stringResource(page.title),
                    style = MaterialTheme.typography.headlineLarge,
                    color = Color.White,
                )
                Text(
                    textAlign = TextAlign.End,
                    text = stringResource(page.description),
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.White,
                )
            }
        }
        Box(
            modifier = Modifier.weight(0.25f)
        ) {
            Image(
                modifier = Modifier.fillMaxSize(),
                painter = painterResource(page.image),
                contentDescription = "icon"
            )
        }
        Box(
            modifier = Modifier
                .weight(0.1f)
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator(
                progress = { progress },
                trackColor = MaterialTheme.colorScheme.secondary,
                gapSize = 0.dp,
                modifier = Modifier.size(60.dp),
                strokeCap = StrokeCap.Butt
            )
            Icon(
                painter = painterResource(
                    if(page == OnboardingPages.Page3) R.drawable.check
                    else R.drawable.arrow_left
                ),
                contentDescription = "next",
                tint = Color.Unspecified,
                modifier = Modifier.clickable(
                    interactionSource = interactionSource,
                    indication = null
                ) {
                    if(page != OnboardingPages.Page3) page = page.next()
                    else navController.navigate(DemoRoutes.AuthRoute)
                }
            )
        }
    }
}

@Preview
@Composable
fun Preview() {
    OnboardingScreen(rememberNavController())
}