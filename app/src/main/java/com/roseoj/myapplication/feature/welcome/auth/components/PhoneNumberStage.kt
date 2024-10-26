package com.roseoj.myapplication.feature.welcome.auth.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.roseoj.demo.R


@Composable
fun PhoneNumberStage(
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
