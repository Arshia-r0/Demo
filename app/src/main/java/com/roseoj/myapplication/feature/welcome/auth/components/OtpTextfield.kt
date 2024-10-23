package com.roseoj.myapplication.feature.welcome.auth.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Preview(showBackground = true)
@Composable
fun OtpTextField(
    otp: TextFieldValue = TextFieldValue(),
    otpError: Boolean = false,
    setOtp: (TextFieldValue) -> Unit = {},
    focusManager: FocusManager = LocalFocusManager.current
) {
    BasicTextField(
        modifier = Modifier.fillMaxWidth(),
        value = otp,
        onValueChange = {
            setOtp(it)
        },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.NumberPassword),
        decorationBox = {
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                repeat(5) { index ->
                    CharView(
                        index = index,
                        text = otp.text,
                        otpError = otpError
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                }
            }
        }
    )
}

@Composable
private fun CharView(
    index: Int = 0,
    text: String,
    otpError: Boolean = false
) {
    val isFocused = text.length == index
    val char = when {
        index >= text.length -> ""
        else -> text[index].toString()
    }
    Text(
        modifier = Modifier
            .width(55.dp)
            .height(55.dp)
            .border(
                1.dp, when {
                    otpError -> MaterialTheme.colorScheme.error
                    isFocused -> MaterialTheme.colorScheme.primary
                    else -> MaterialTheme.colorScheme.secondary
                }, RoundedCornerShape(8.dp)
            )
            .wrapContentHeight()
            .padding(2.dp),
        text = char,
        style = MaterialTheme.typography.headlineMedium,
        textAlign = TextAlign.Center,
    )
}
