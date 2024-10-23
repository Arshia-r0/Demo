package com.roseoj.myapplication.feature.welcome.auth

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.LinkAnnotation
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextLinkStyles
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withLink
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.roseoj.demo.R
import com.roseoj.myapplication.core.common.convertToTime
import com.roseoj.myapplication.feature.welcome.auth.components.OtpTextField
import com.roseoj.myapplication.feature.welcome.auth.components.PhoneNumberTextField
import kotlinx.coroutines.delay
import org.koin.androidx.compose.koinViewModel


@Composable
fun AuthScreen(
    navController: NavController = rememberNavController(),
    viewModel: AuthScreenViewModel = koinViewModel()
) {
    var authStage by viewModel.authStage
    var otp by viewModel.otp
    var timeLeft by viewModel.timeLeft
    var countDown by viewModel.countDown
    val phoneNumber by viewModel.phoneNumber
    val isChecked by viewModel.isChecked
    val otpError by  viewModel.otpError
    val invalidNumber by viewModel.invalidNumber
    val navigateToPhoneNumberScreen = {
        authStage = AuthStage.PhoneNumber
        otp = TextFieldValue()
    }
    LaunchedEffect(countDown) {
        while(countDown) {
            delay(1000L)
            timeLeft--
            if(timeLeft == 0) {
                countDown = false
            }
        }
    }
    Content(
        authStage = authStage,
        navController = navController,
        phoneNumber = phoneNumber,
        otp = otp,
        isChecked = isChecked,
        invalidNumber = invalidNumber,
        setPhoneNumber = { viewModel.setPhoneNumber(it) },
        setOtp = { viewModel.setOtp(it)},
        submitPhoneNumber = { viewModel.submitPhoneNumber() },
        submitOtp = { viewModel.submitOtp(navController) },
        setIsChecked = { viewModel.setIsChecked(it) },
        navigateToPhoneNumberScreen = navigateToPhoneNumberScreen,
        otpError = otpError,
        timeLeft = timeLeft,
        countDown = countDown,
        requestOtp = { viewModel.requestOtp() }
    )
    BackHandler {
        if(authStage == AuthStage.Otp) navigateToPhoneNumberScreen()
        else navController.navigateUp()
    }
}

@Preview(showBackground = true)
@PreviewScreenSizes
@Composable
fun Content(
    navController: NavController = rememberNavController(),
    authStage: AuthStage = AuthStage.PhoneNumber,
    phoneNumber: TextFieldValue = TextFieldValue(),
    otp: TextFieldValue = TextFieldValue(),
    isChecked: Boolean = false,
    invalidNumber: Boolean = false,
    otpError: Boolean = false,
    timeLeft: Int = countDownTime,
    countDown: Boolean = false,
    setPhoneNumber: (TextFieldValue) -> Unit = {},
    setOtp: (TextFieldValue) -> Unit = {},
    submitPhoneNumber: () -> Unit = {},
    submitOtp: () -> Unit = {},
    setIsChecked: (Boolean) -> Unit = {},
    navigateToPhoneNumberScreen: () -> Unit = {},
    requestOtp: () -> Unit = {}
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            painter = painterResource(R.drawable.tarkhine),
            contentDescription = "ICON",
            tint = Color.Unspecified
        )
        Spacer(modifier = Modifier.height(50.dp))
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if(authStage == AuthStage.PhoneNumber) {
                AuthStage(
                    phoneNumber = phoneNumber,
                    invalidNumber = invalidNumber,
                    isChecked = isChecked,
                    submitPhoneNumber =  { submitPhoneNumber() },
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

@Composable
fun AuthStage(
    phoneNumber: TextFieldValue = TextFieldValue(),
    invalidNumber: Boolean = false,
    isChecked: Boolean = false,
    submitPhoneNumber: () -> Unit = {},
    setPhoneNumber: (TextFieldValue) -> Unit = {},
    setIsChecked: (Boolean) -> Unit = {},
) {
    Text(
        text = stringResource(R.string.auth_title),
        textAlign = TextAlign.End,
        style = MaterialTheme.typography.headlineSmall
    )
    Text(
        textAlign = TextAlign.End,
        text = stringResource(R.string.auth_description),
        style = MaterialTheme.typography.bodyLarge
    )
    Spacer(modifier = Modifier.height(20.dp))
    PhoneNumberTextField(
        phoneNumber = phoneNumber,
        invalidNumber = invalidNumber,
        setPhoneNumber = { setPhoneNumber(it) }
    )
    Button(
        onClick = { submitPhoneNumber() },
        modifier = Modifier.fillMaxWidth().padding(horizontal = 50.dp),
        shape = RoundedCornerShape(5.dp)
    ) {
        Text(
            text = stringResource(R.string.auth_button)
        )
    }
    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            modifier = Modifier.clickable { setIsChecked(!isChecked) },
            text = stringResource(R.string.auth_checkbox),
        )
        Checkbox(
            checked = isChecked,
            onCheckedChange = { setIsChecked(it) }
        )
    }
}

@Composable
fun OtpStage(
    phoneNumber: TextFieldValue = TextFieldValue(),
    otp: TextFieldValue = TextFieldValue(),
    otpError: Boolean = false,
    timeLeft: Int = countDownTime,
    countDown: Boolean = false,
    setOtp: (TextFieldValue) -> Unit = {},
    navigateToPhoneNumberScreen: () -> Unit = {},
    submitOtp: () -> Unit = {},
    requestOtp: () -> Unit = {}
) {
    val changeNumberText = buildAnnotatedString {
        withLink(
            LinkAnnotation.Clickable(
                tag = "change Number",
                styles = TextLinkStyles(
                    style = SpanStyle(MaterialTheme.colorScheme.primary, textDecoration = TextDecoration.Underline)
                )
            ) { navigateToPhoneNumberScreen() }
        ) { append(stringResource(R.string.otp_change_number)) }
    }
    val requestOtpText = buildAnnotatedString {
        withLink(
            LinkAnnotation.Clickable(
                tag = "change Number",
                styles = TextLinkStyles(
                    style = SpanStyle(MaterialTheme.colorScheme.primary, textDecoration = TextDecoration.Underline)
                )
            ) { requestOtp() }
        ) { append(stringResource(R.string.otp_request_otp)) }
    }
    Text(
        text = stringResource(R.string.otp_title),
        textAlign = TextAlign.End,
        style = MaterialTheme.typography.headlineSmall
    )
    Text(
        textAlign = TextAlign.End,
        text = stringResource(R.string.otp_description1) + " "+ phoneNumber.text + " " + stringResource(R.string.otp_description2),
        style = MaterialTheme.typography.bodyLarge
    )
    Spacer(modifier = Modifier.height(20.dp))
    OtpTextField(
        otp = otp,
        otpError = otpError,
        setOtp = { setOtp(it) }
    )
    Row(
        modifier = Modifier.fillMaxWidth().padding(horizontal = 55.dp, vertical = 5.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = changeNumberText,
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(5.dp)
        ){
            if(countDown) {
                Text(
                    text = stringResource(R.string.otp_timer)
                )
                Text(
                    text = timeLeft.convertToTime()
                )
                Icon(
                    painter = painterResource(R.drawable.clock),
                    tint = Color.Unspecified,
                    contentDescription = "clock icon"
                )
            } else {
                Text(
                    text = requestOtpText
                )
            }
        }
    }
    Button(
        onClick = { submitOtp() },
        modifier = Modifier.fillMaxWidth().padding(horizontal = 50.dp),
        shape = RoundedCornerShape(5.dp)
    ) {
        Text(
            text = stringResource(R.string.otp_button),
        )
    }
}
