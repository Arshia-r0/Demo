package com.roseoj.myapplication.feature.welcome.onboarding

import com.roseoj.demo.R


enum class OnboardingScreen(
    val title: Int,
    val description: Int,
    val image: Int,
    val progress: Float
) {
    Page1(
        title = R.string.onboarding_page1_title,
        description = R.string.onboarding_page1_description,
        image = R.drawable.page1,
        progress = 0.33f
    ),
    Page2(
        title = R.string.onboarding_page2_title,
        description = R.string.onboarding_page2_description,
        image = R.drawable.page2,
        progress = 0.66f
    ),
    Page3(
        title = R.string.onboarding_page3_title,
        description = R.string.onboarding_page3_description,
        image = R.drawable.page3,
        progress = 1f
    )
}