package com.roseoj.myapplication.feature.welcome.auth.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import androidx.compose.ui.unit.dp
import com.roseoj.demo.R
import com.roseoj.myapplication.core.common.convertToTime
import com.roseoj.myapplication.feature.welcome.auth.countDownTime


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
        text = stringResource(R.string.otp_description1) + " "+ phoneNumber.text + " " + stringResource(
            R.string.otp_description2),
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
