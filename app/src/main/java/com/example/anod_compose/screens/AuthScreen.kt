package com.example.anod_compose.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.anod_compose.R
import com.example.anod_compose.navigation.NavRoute
import com.example.anod_compose.ui.theme.Anod_ComposeTheme
import com.example.anod_compose.ui.theme.Blue
import com.example.anod_compose.ui.theme.BlueWhite

@Composable
fun AuthScreen(navController: NavHostController) {
    // A column container for image and column of buttons
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // ANOD image
        Image(
            modifier = Modifier
                .weight(3f),
            painter = painterResource(id = R.drawable.anod_logo),
            contentDescription = "anod_svg"
        )
        // Sign up and sign in buttons
        SignButtons(
            Modifier.fillMaxWidth().weight(1f),
            navController
        )
    }
}

@Composable
fun SignButtons(modifier: Modifier, navController: NavHostController) {
    // A column of buttons
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SignUpButton(navController)

        SignInButton(navController)
    }
}

@Composable
fun SignInButton(navController: NavHostController) {
    // A text button
    TextButton(
        onClick = {
            navController.navigate(NavRoute.SignIn.route)
        }
    ) {
        Text(
            modifier = Modifier
                .alpha(0.7f)
                .padding(8.dp),
            text = stringResource(R.string.sign_in_button_text),
            color = Blue,
            style = MaterialTheme.typography.bodyMedium
        )
    }
}

@Composable
fun SignUpButton(navController: NavHostController) {
    // A button with text
    Button(
        onClick = {
            navController.navigate(NavRoute.SignUp.route)
        },
        modifier = Modifier
            .fillMaxWidth(0.73F)
            .padding(bottom = 10.dp),
        colors = ButtonDefaults.buttonColors(Blue),
        elevation = ButtonDefaults.buttonElevation(
            defaultElevation = 2.dp,
            pressedElevation = 5.dp,
            disabledElevation = 0.dp
        )
    ) {
        Text(
            modifier = Modifier.padding(vertical = 8.dp),
            text = stringResource(R.string.sign_up_button_text),
            style = MaterialTheme.typography.titleMedium,
            color = BlueWhite
        )
    }
}

@Preview(showBackground = true)
@Composable
fun AuthPreview() {
    Anod_ComposeTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            AuthScreen(navController = rememberNavController())
        }
    }
}