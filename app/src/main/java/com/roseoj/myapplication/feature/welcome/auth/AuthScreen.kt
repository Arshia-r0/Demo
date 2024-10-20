package com.roseoj.myapplication.feature.welcome.auth

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.roseoj.demo.R


@Composable
fun AuthScreen(
    navController: NavController = rememberNavController(),
    viewModel: AuthScreenViewModel = hiltViewModel()
) {
    val phoneNumber by viewModel.phoneNumber
    val isChecked by viewModel.isChecked
    Content(
        navController = navController,
        phoneNumber = phoneNumber,
        isChecked = isChecked,
        setPhoneNumber = { viewModel.setPhoneNumber(it) },
        setIsChecked = { viewModel.setIsChecked(it) },
    )
}

@Preview(showBackground = true)
@Composable
fun Content(
    navController: NavController = rememberNavController(),
    phoneNumber: String = "",
    isChecked: Boolean = false,
    setPhoneNumber: (String) -> Unit = {},
    setIsChecked: (Boolean) -> Unit = {},
    focusRequester: FocusRequester = remember { FocusRequester() },
    focusManager: FocusManager = LocalFocusManager.current
) {
    Column(
        modifier = Modifier.padding(vertical = 200.dp),
        verticalArrangement = Arrangement.spacedBy(60.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            painter = painterResource(R.drawable.tarkhine),
            contentDescription = "ICON",
            tint = Color.Unspecified
        )
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
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
            OutlinedTextField(
                value = phoneNumber,
                onValueChange = { setPhoneNumber(it) },
                modifier = Modifier.fillMaxWidth().padding(horizontal = 50.dp),
                singleLine = true,
                label = {
                    Text(
                        modifier = Modifier.fillMaxWidth()
                            .focusRequester(focusRequester),
                        textAlign = TextAlign.End,
                        text = stringResource(R.string.auth_input_label)
                    )
                },
                placeholder = {
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.End,
                        text = stringResource(R.string.auth_input),
                        color = MaterialTheme.colorScheme.secondary
                    )
                },
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = MaterialTheme.colorScheme.primary,
                    unfocusedBorderColor = MaterialTheme.colorScheme.secondary,
                    errorBorderColor = MaterialTheme.colorScheme.error
                ),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Phone,
                    imeAction = ImeAction.Done
                ),
                keyboardActions = KeyboardActions(
                    onDone = {
                        focusManager.clearFocus()
                    }
                )
            )
            Button(
                onClick = {  },
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
                    text = stringResource(R.string.auth_checkbox),
                )
                Checkbox(
                    checked = isChecked,
                    onCheckedChange = { setIsChecked(it) }
                )
            }
        }
    }
}
