package com.example.anod_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.anod_compose.navigation.AnodNavHost
import com.example.anod_compose.ui.theme.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Anod_ComposeTheme {
                AnodNavHost()
            }
        }
    }
}

@Preview
@Composable
fun DefaultPreview() {
    Anod_ComposeTheme {
        AnodNavHost()
    }
}