package com.roseoj.myapplication.feature.welcome.auth

import android.graphics.drawable.shapes.RoundRectShape
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.roseoj.demo.R


@Composable
fun AuthScreen(
    navController: NavController,
) {
    var phoneNumber by remember { mutableStateOf("") }
    var checked by remember { mutableStateOf(false) }
    Column(
        modifier = Modifier.padding(vertical = 200.dp),
        verticalArrangement = Arrangement.spacedBy(60.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            painter = painterResource(R.drawable.tarkhine),
            contentDescription = "tarkhine label",
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
                onValueChange = { phoneNumber = it },
                modifier = Modifier.fillMaxWidth().padding(horizontal = 50.dp),
                singleLine = true,
                label = {
                    Text(
                        modifier = Modifier.fillMaxWidth(),
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
                )
            )
            Button(
                onClick = {},
                modifier = Modifier.fillMaxWidth().padding(horizontal = 50.dp),
                shape = RoundedCornerShape(5.dp)
            ) {
                Text(
                    text = stringResource(R.string.auth_button)
                )
            }
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = stringResource(R.string.auth_checkbox),
                )
                Checkbox(
                    checked = checked,
                    onCheckedChange = { checked = it }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Preview() {
    AuthScreen(
        rememberNavController(),
    )
}