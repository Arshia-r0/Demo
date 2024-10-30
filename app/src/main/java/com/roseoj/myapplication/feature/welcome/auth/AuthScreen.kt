package com.roseoj.myapplication.feature.welcome.auth

import androidx.activity.compose.BackHandler
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.roseoj.demo.R
import com.roseoj.myapplication.core.designsystem.component.DemoSnackbar
import com.roseoj.myapplication.feature.welcome.auth.components.OtpStage
import com.roseoj.myapplication.feature.welcome.auth.components.PhoneNumberStage
import kotlinx.coroutines.delay
import org.koin.androidx.compose.koinViewModel


@Composable
fun AuthScreen(
    isOffline: Boolean,
    snackbarHostState: SnackbarHostState,
    viewModel: AuthScreenViewModel = koinViewModel(),
) {
    var authStage by viewModel.authStage
    var otp by viewModel.otp
    var timeLeft by viewModel.timeLeft
    var countDown by viewModel.countDown
    val phoneNumber by viewModel.phoneNumber
    val isChecked by viewModel.isChecked
    val otpError by viewModel.otpError
    val invalidNumber by viewModel.invalidNumber
    val context = LocalContext.current
    val navigateToPhoneNumberScreen = {
        authStage = AuthStage.PhoneNumber
        otp = TextFieldValue()
    }
    LaunchedEffect(isOffline) {
        if (isOffline) {
            snackbarHostState.showSnackbar(
                message = context.getString(R.string.not_connected_message),
                duration = SnackbarDuration.Indefinite
            )
        }
    }
    LaunchedEffect(countDown) {
        while (countDown) {
            delay(1000L)
            timeLeft--
            if (timeLeft == 0) {
                countDown = false
            }
        }
    }
    Content(
        authStage = authStage,
        phoneNumber = phoneNumber,
        otp = otp,
        isChecked = isChecked,
        invalidNumber = invalidNumber,
        snackbarHostState = snackbarHostState,
        setPhoneNumber = { viewModel.setPhoneNumber(it) },
        setOtp = { viewModel.setOtp(it) },
        submitPhoneNumber = { viewModel.submitPhoneNumber(isOffline) },
        submitOtp = { viewModel.submitOtp(isOffline) },
        setIsChecked = { viewModel.setIsChecked(it) },
        navigateToPhoneNumberScreen = navigateToPhoneNumberScreen,
        otpError = otpError,
        timeLeft = timeLeft,
        countDown = countDown,
        requestOtp = { viewModel.requestOtp() }
    )
    BackHandler {
        if (authStage == AuthStage.Otp) navigateToPhoneNumberScreen()
    }
}

@Preview(showBackground = true)
@Composable
fun Content(
    authStage: AuthStage = AuthStage.Otp,
    phoneNumber: TextFieldValue = TextFieldValue(),
    otp: TextFieldValue = TextFieldValue(),
    isChecked: Boolean = false,
    invalidNumber: Boolean = false,
    otpError: Boolean = false,
    timeLeft: Int = countDownTime,
    countDown: Boolean = false,
    snackbarHostState: SnackbarHostState = SnackbarHostState(),
    setPhoneNumber: (TextFieldValue) -> Unit = {},
    setOtp: (TextFieldValue) -> Unit = {},
    submitPhoneNumber: () -> Unit = {},
    submitOtp: () -> Unit = {},
    setIsChecked: (Boolean) -> Unit = {},
    navigateToPhoneNumberScreen: () -> Unit = {},
    requestOtp: () -> Unit = {}
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        snackbarHost = {
            SnackbarHost(snackbarHostState) {
                DemoSnackbar(it)
            }
        },
    ) { ip ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(ip),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                painter = painterResource(R.drawable.tarkhine),
                contentDescription = "ICON",
                tint = Color.Unspecified
            )
            Spacer(modifier = Modifier.height(50.dp))
            AnimatedContent(
                targetState = authStage,
                label = "stage",
                transitionSpec = {
                    slideIntoContainer(
                        towards = if (authStage == AuthStage.PhoneNumber) AnimatedContentTransitionScope.SlideDirection.Start
                        else AnimatedContentTransitionScope.SlideDirection.End,
                        animationSpec = tween(200)
                    ) togetherWith slideOutOfContainer(
                        towards = if (authStage == AuthStage.PhoneNumber) AnimatedContentTransitionScope.SlideDirection.Start
                        else AnimatedContentTransitionScope.SlideDirection.End,
                        animationSpec = tween(200)
                    )
                }) {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    if (it == AuthStage.PhoneNumber) {
                        PhoneNumberStage(
                            phoneNumber = phoneNumber,
                            invalidNumber = invalidNumber,
                            isChecked = isChecked,
                            submitPhoneNumber = { submitPhoneNumber() },
                            setPhoneNumber = { setPhoneNumber(it) },
                            setIsChecked = { setIsChecked(it) }
                        )
                    } else {
                        OtpStage(
                            phoneNumber = phoneNumber,
                            otp = otp,
                            otpError = otpError,
                            timeLeft = timeLeft,
                            countDown = countDown,
                            setOtp = { setOtp(it) },
                            navigateToPhoneNumberScreen = { navigateToPhoneNumberScreen() },
                            submitOtp = { submitOtp() },
                            requestOtp = { requestOtp() }
                        )
                    }
                }
            }
        }
    }
}
