package com.example.anod_compose.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.anod_compose.ui.theme.Anod_ComposeTheme

@Composable
fun MainScreen(navController: NavHostController) {
}

@Preview(showBackground = true)
@Composable
fun MainPreview() {
    Anod_ComposeTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            MainScreen(navController = rememberNavController())
        }
    }
}