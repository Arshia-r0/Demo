package com.roseoj.myapplication.feature.welcome.onboarding

import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
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
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.roseoj.demo.R
import com.roseoj.myapplication.app.navigation.DemoRoutes
import com.roseoj.myapplication.core.common.next
import com.roseoj.myapplication.feature.welcome.WelcomeRoutes
import org.koin.androidx.compose.koinViewModel


@Preview
@PreviewScreenSizes
@Composable
fun OnboardingScreen(
    navController: NavController = rememberNavController(),
    viewModel: OnboardingScreenViewModel = koinViewModel()
) {
    var page by viewModel.page
    val progress by animateFloatAsState(page.progress, label = "ProgressIndicator")
    val interactionSource = remember { MutableInteractionSource() }
    val nextScreen = {
        navController.navigate(WelcomeRoutes.AuthRoute)
    }
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Box(
            modifier = Modifier.fillMaxWidth().weight(0.4f)
                .background(MaterialTheme.colorScheme.primary),
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(
                    onClick = { nextScreen() }
                ) {
                    Icon(
                        painter = painterResource(R.drawable.close),
                        contentDescription = "close",
                        tint = Color.Unspecified
                    )
                }
            }
            AnimatedContent(
                targetState = page,
                label = "title",
                transitionSpec = {
                    slideIntoContainer(
                        towards = AnimatedContentTransitionScope.SlideDirection.End,
                        animationSpec = tween(200)
                    ) togetherWith slideOutOfContainer(
                        towards = AnimatedContentTransitionScope.SlideDirection.End,
                        animationSpec = tween(200)
                    )
                }
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 20.dp)
                        .padding(top = 60.dp, bottom = 100.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        textAlign = TextAlign.End,
                        text = stringResource(it.title),
                        style = MaterialTheme.typography.headlineLarge,
                        color = Color.White,
                    )
                    Text(
                        textAlign = TextAlign.End,
                        text = stringResource(it.description),
                        style = MaterialTheme.typography.bodyMedium,
                        color = Color.White,
                    )
                }
            }
        }
        Box(
            modifier = Modifier.weight(0.4f)
        ) {
            AnimatedContent(
                targetState = page,
                label = "icon",
                transitionSpec = {
                    slideIntoContainer(
                        towards = AnimatedContentTransitionScope.SlideDirection.End,
                        animationSpec = tween(200)
                    ) togetherWith slideOutOfContainer(
                        towards = AnimatedContentTransitionScope.SlideDirection.End,
                        animationSpec = tween(200)
                    )
                }
            ) {
                Image(
                    modifier = Modifier.fillMaxSize(),
                    painter = painterResource(it.image),
                    contentDescription = "icon"
                )
            }
        }
        Box(
            modifier = Modifier
                .weight(0.2f)
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
                    else nextScreen()
                }
            )
        }
    }
}
