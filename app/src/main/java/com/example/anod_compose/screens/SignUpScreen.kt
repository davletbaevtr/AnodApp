package com.example.anod_compose.screens

import android.content.Context
import android.content.SharedPreferences
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.Navigation
import androidx.navigation.compose.rememberNavController
import com.example.anod_compose.navigation.NavRoute
import com.example.anod_compose.ui.theme.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignUpScreen(navController: NavHostController, pref: SharedPreferences) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        // A box container with text //  and "back" button
        Box(
            modifier = Modifier
                .fillMaxSize()
                .weight(1f)
        ) {
            Text(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 50.dp)
                    .alpha(0.3f)
                    .align(Alignment.TopCenter),
                text = "Регистрация учетной записи",
                style = MaterialTheme.typography.titleLarge,
                color = Blue,
                textAlign = TextAlign.Center
            )
            Button(
                onClick = {
                    navController.popBackStack()
                },
                colors = ButtonDefaults.buttonColors(BlueWhite)
            ) {
                Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "", tint = Blue)
            }
        }
        Box(
            modifier = Modifier
                .fillMaxSize()
                .weight(1f)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top
            ) {
                val textStateEmail = remember { mutableStateOf("") }
                val textStatePassword = remember { mutableStateOf("") }

                TextField(
                    modifier = Modifier
                        .fillMaxWidth(0.9f),
                    value = textStateEmail.value,
                    onValueChange = { newText -> textStateEmail.value = newText },
                    textStyle = MaterialTheme.typography.bodyLarge,
                    label = {
                        Text(
                            modifier = Modifier.padding(top = 5.dp, bottom = 10.dp),
                            text = "Email",
                            style = MaterialTheme.typography.bodyLarge
                        )
                    },
                    shape = Shapes.medium,
                    colors = TextFieldDefaults.textFieldColors(
                        unfocusedIndicatorColor = NoColor,
                        focusedIndicatorColor = NoColor
                    ),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
                )
                TextField(
                    modifier = Modifier
                        .fillMaxWidth(0.9f)
                        .padding(vertical = 20.dp),
                    value = textStatePassword.value,
                    onValueChange = { newText -> textStatePassword.value = newText },
                    textStyle = MaterialTheme.typography.bodyLarge,
                    shape = Shapes.medium,
                    label = {
                        Text(
                            modifier = Modifier.padding(top = 5.dp, bottom = 10.dp),
                            text = "Password",
                            style = MaterialTheme.typography.bodyLarge
                        )
                    },
                    visualTransformation = PasswordVisualTransformation(),
                    colors = TextFieldDefaults.textFieldColors(
                        unfocusedIndicatorColor = NoColor,
                        focusedIndicatorColor = NoColor
                    ),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
                )
            }
        }
        Box(
            modifier = Modifier
                .fillMaxSize()
                .weight(0.8f)
        ) {
            Button(
                onClick = { // check valid email and password and add to db then go to main
                    navController.navigate(NavRoute.Main.route)
                },
                modifier = Modifier
                    .fillMaxWidth(0.73f)
                    .align(Alignment.Center),
                colors = ButtonDefaults.buttonColors(Blue),
                elevation = ButtonDefaults.buttonElevation(
                    defaultElevation = 2.dp,
                    pressedElevation = 5.dp,
                    disabledElevation = 0.dp
                )
            ) {
                Text(
                    modifier = Modifier.padding(vertical = 5.dp),
                    text = "Регистрация",
                    style = MaterialTheme.typography.titleMedium,
                    color = BlueWhite
                )
            }
        }
    }
}