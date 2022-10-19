package com.example.anod_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.anod_compose.screens.AuthScreen
import com.example.anod_compose.ui.theme.*

class AuthActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Anod_ComposeTheme {
                AuthScreen()
            }
        }
    }
}