package com.example.anod_compose.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.example.anod_compose.R
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.anod_compose.navigation.NavRoute
import com.example.anod_compose.ui.theme.Anod_ComposeTheme
import com.example.anod_compose.ui.theme.Blue
import com.example.anod_compose.ui.theme.BlueWhite
import com.example.anod_compose.ui.theme.Shapes

@Composable
fun HelloScreen(navController: NavHostController) {
    // Column with Texts and Button
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Texts and Contacts with weight 3
        HelloTextAndContacts(
            Modifier
                .fillMaxSize()
                .weight(3f)
        )

        // Button with text and weight 1
        HelloButton(
            Modifier
                .fillMaxSize()
                .weight(1f), navController
        )
    }
}

@Composable
fun HelloTextAndContacts(modifier: Modifier) {
    // Box with modifier mod(weight, size)
    Box(
        modifier = modifier
    ) {
        // Column with texts contacts
        Column(
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.Center),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Text with border and elevation
            HelloBorderText()

            // Just text
            HelloText2()

            // Space between text and contacts
            Spacer(modifier = Modifier.fillMaxHeight(0.3f))

            // Contacts
            HelloContacts()
        }
    }
}

@Composable
fun HelloButton(modifier: Modifier, navController: NavHostController) {
    // Box with modifier mod(weight, size)
    Box(
        modifier = modifier
    ) {
        // Clickable button with elevation
        // going to AuthActivity
        Button(
            onClick = {
                navController.navigate(NavRoute.Auth.route)
            },
            modifier = Modifier
                .fillMaxWidth(0.73f)
                .align(Alignment.Center),
            colors = ButtonDefaults.buttonColors(Blue),
            elevation = ButtonDefaults.buttonElevation(
                defaultElevation = 2.dp,
                pressedElevation = 5.dp,
                disabledElevation = 0.dp
            ),
            shape = Shapes.extraLarge
        ) {
            Text(
                modifier = Modifier.padding(vertical = 5.dp),
                text = stringResource(R.string.hello_button_text),
                style = MaterialTheme.typography.titleMedium,
                color = BlueWhite
            )
        }
    }
}

@Composable
fun HelloBorderText() {
    // Use "Button" to do border with elevation
    Button(
        onClick = { /*TODO*/ },
        colors = ButtonDefaults.buttonColors(BlueWhite),
        elevation = ButtonDefaults.buttonElevation(
            defaultElevation = 2.dp,
            pressedElevation = 5.dp,
            disabledElevation = 0.dp
        ),
        shape = Shapes.medium
    ) {
        // Column with texts
        Column(
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Title text
            Text(
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .padding(vertical = 10.dp),
                text = stringResource(R.string.hello_text1),
                style = MaterialTheme.typography.titleMedium,
                color = Blue,
                textAlign = TextAlign.Center
            )
            Text(
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .padding(vertical = 10.dp)
                    .alpha(0.8f),
                text = stringResource(R.string.hello_text2),
                style = MaterialTheme.typography.bodyLarge,
                color = Blue,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Composable
fun HelloText2() {
    Text(
        modifier = Modifier
            .fillMaxWidth(0.9f)
            .padding(vertical = 20.dp)
            .alpha(0.8f),
        text = stringResource(R.string.hello_text3),
        style = MaterialTheme.typography.bodyLarge,
        color = Blue,
        textAlign = TextAlign.Center
    )
}

@Composable
fun HelloContacts() {
    // Contacts text
    Text(
        modifier = Modifier
            .fillMaxWidth(0.7f)
            .padding(bottom = 10.dp),
        text = "Наши контакты:",
        style = MaterialTheme.typography.bodyLarge,
        color = Blue
    )
    // Using LazyRow for dynamic contacts
    LazyRow(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.Bottom
    ) {
        itemsIndexed(
            listOf(R.drawable.vk_logo, R.drawable.inst_logo, R.drawable.tg_logo)
        ) { index, value ->
            IconButton(
                modifier = Modifier.padding(10.dp),
                onClick = { /*TODO*/ }
            ) {
                Image(
                    painter = painterResource(value),
                    contentDescription = "contact $index"
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HelloPreview() {
    Anod_ComposeTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            HelloScreen(navController = rememberNavController())
        }
    }
}